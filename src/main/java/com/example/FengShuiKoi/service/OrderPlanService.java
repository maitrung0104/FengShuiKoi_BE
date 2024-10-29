package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.*;
import com.example.FengShuiKoi.entity.Enum.PaymentEnums;
import com.example.FengShuiKoi.entity.Enum.Role;
import com.example.FengShuiKoi.entity.Enum.TransactionsEnum;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.OrderPlanDetailRequest;
import com.example.FengShuiKoi.model.OrderPlanRequest;
import com.example.FengShuiKoi.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OrderPlanService {
    @Autowired
    OrderPlanRepository orderPlanRepository;

    @Autowired
    AuthService authService;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    TransactionRepository transactionsRepository;

    public OrderPlan create(OrderPlanRequest orderPlanRequest) {
        Account member = authService.getCurrentAccount();

        OrderPlan orderPlan = new OrderPlan();
        List<OrderPlanDetail> orderDetailPlans = new ArrayList<>();
        float total = 0;

        orderPlan.setMember(member);
        orderPlan.setDate(new Date());

        for (OrderPlanDetailRequest orderPlanDetailRequest : orderPlanRequest.getDetail()) {
            Plan plan = planRepository.findProductById(orderPlanDetailRequest.getPlanId());

            OrderPlanDetail orderDetailPlan = new OrderPlanDetail();
            orderDetailPlan.setOrderPlan(orderPlan);
            orderDetailPlan.setQuantity(orderPlanDetailRequest.getQuantity());
            orderDetailPlan.setPrice(plan.getPrice());
            orderDetailPlan.setPlan(plan);

            orderDetailPlans.add(orderDetailPlan);
            total += orderDetailPlan.getPrice() * orderDetailPlan.getQuantity();
        }
        orderPlan.setOrderDetailPlans(orderDetailPlans);
        orderPlan.setTotal(total);
        return orderPlanRepository.save(orderPlan);
    }

    public OrderPlan update(UUID id, OrderPlanRequest orderPlanRequest) {
        OrderPlan orderPlan = orderPlanRepository.findOrderPlanById(id);
        List<OrderPlanDetail> orderDetailPlans = new ArrayList<>();
        float total = 0;
        for (OrderPlanDetailRequest orderPlanDetailRequest : orderPlanRequest.getDetail()) {
            Plan plan = planRepository.findProductById(orderPlanDetailRequest.getPlanId());
            OrderPlanDetail orderDetailPlan = new OrderPlanDetail();
            orderDetailPlan.setOrderPlan(orderPlan);
            orderDetailPlan.setQuantity(orderPlanDetailRequest.getQuantity());
            orderDetailPlan.setPrice(plan.getPrice());
            orderDetailPlan.setPlan(plan);
            orderDetailPlans.add(orderDetailPlan);
            total += orderDetailPlan.getPrice() * orderDetailPlan.getQuantity();
        }
        orderPlan.setOrderDetailPlans(orderDetailPlans);
        orderPlan.setTotal(total);
        return orderPlanRepository.save(orderPlan);
    }

    public void deleteOrderPlan(UUID id) {
        OrderPlan orderPlan = orderPlanRepository.findOrderPlanById(id);
        orderPlanRepository.delete(orderPlan);
    }

    public List<OrderPlan> getAll() {
        Account member = authService.getCurrentAccount();
        List<OrderPlan> orderPlans = orderPlanRepository.findOrderPlanByMember(member);
        if (orderPlans == null || orderPlans.isEmpty()) {
            throw new EntityNotFoundException("No orders found for the current customer");
        }
        return orderPlans;
    }

    public OrderPlan get(UUID id) {
        OrderPlan orderPlan = orderPlanRepository.findOrderPlanById(id);
        if (orderPlan == null) {
            throw new EntityNotFoundException("Order not found");
        }
        return orderPlan;
    }

    public String createUrl(OrderPlanRequest orderPlanRequest) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime createDate = LocalDateTime.now();
        String formattedCreateDate = createDate.format(formatter);

        // create order
        OrderPlan orderPlan = create(orderPlanRequest);

        float money = orderPlan.getTotal() * 100;
        String amount = String.valueOf((int) money);

        String tmnCode = "0I712H9B";
        String secretKey = "ZOPSQ8G5KQFVU2PDYNEA0VB05BQUVSZO";
        String vnpUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
        String returnUrl = "https://www.google.com.vn/?hl=vi" + orderPlan.getId(); //frontend
        String currCode = "VND";

        Map<String, String> vnpParams = new TreeMap<>();
        vnpParams.put("vnp_Version", "2.1.0");
        vnpParams.put("vnp_Command", "pay");
        vnpParams.put("vnp_TmnCode", tmnCode);
        vnpParams.put("vnp_Locale", "vn");
        vnpParams.put("vnp_CurrCode", currCode);
        vnpParams.put("vnp_TxnRef", orderPlan.getId().toString());
        vnpParams.put("vnp_OrderInfo", "Thanh toan cho ma GD: " + orderPlan.getId());
        vnpParams.put("vnp_OrderType", "other");
        vnpParams.put("vnp_Amount", amount);
        vnpParams.put("vnp_ReturnUrl", returnUrl);
        vnpParams.put("vnp_CreateDate", formattedCreateDate);
        vnpParams.put("vnp_IpAddr", "128.199.178.23");

        StringBuilder signDataBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : vnpParams.entrySet()) {
            signDataBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString()));
            signDataBuilder.append("=");
            signDataBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString()));
            signDataBuilder.append("&");
        }
        signDataBuilder.deleteCharAt(signDataBuilder.length() - 1); // Remove last '&'

        String signData = signDataBuilder.toString();
        String signed = generateHMAC(secretKey, signData);

        vnpParams.put("vnp_SecureHash", signed);

        StringBuilder urlBuilder = new StringBuilder(vnpUrl);
        urlBuilder.append("?");
        for (Map.Entry<String, String> entry : vnpParams.entrySet()) {
            urlBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString()));
            urlBuilder.append("=");
            urlBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString()));
            urlBuilder.append("&");
        }
        urlBuilder.deleteCharAt(urlBuilder.length() - 1); // Remove last '&'

        return urlBuilder.toString();
    }

    private String generateHMAC(String secretKey, String signData) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSha512 = Mac.getInstance("HmacSHA512");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
        hmacSha512.init(keySpec);
        byte[] hmacBytes = hmacSha512.doFinal(signData.getBytes(StandardCharsets.UTF_8));

        StringBuilder result = new StringBuilder();
        for (byte b : hmacBytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public void createTransaction(UUID orderID) {
        OrderPlan orderPlan = orderPlanRepository.findOrderPlanById(orderID);

        if (orderPlan.getOrderDetailPlans().isEmpty()) {
            throw new EntityNotFoundException("OrderPlan has no details");
        }

        // Create payment
        Payment payment = new Payment();
        payment.setOrderPlan(orderPlan);
        payment.setCreateAt(new Date());
        payment.setPayment_method(PaymentEnums.BANKING);

        Set<Transactions> setTransactions = new HashSet<>();

        // Create transaction from Owner to Admin
        Transactions transactions1 = new Transactions();

        //VNPay --> Member
        Account member = authService.getCurrentAccount();
        transactions1.setFrom(null);
        transactions1.setTo(member);
        transactions1.setPayment(payment);
        transactions1.setStatus(TransactionsEnum.SUCCESS);
        transactions1.setDescription("VNPay to Member");

        setTransactions.add(transactions1);

        Transactions transactions2 = new Transactions();
        //VNPay --> ADMIN
        Account admin = accountRepository.findAccountByRole(Role.ADMIN);
        transactions2.setFrom(member);
        transactions2.setTo(admin);
        transactions2.setPayment(payment);
        transactions2.setStatus(TransactionsEnum.SUCCESS);
        transactions2.setDescription("Member to Admin");
        float newBalance = admin.getBalance() + orderPlan.getTotal();
        admin.setBalance(newBalance);

        setTransactions.add(transactions2);

        accountRepository.save(admin);
        member.setRole(Role.OWNER);
        accountRepository.save(member);
        payment.setTransactions(setTransactions);
        paymentRepository.save(payment);
    }



}