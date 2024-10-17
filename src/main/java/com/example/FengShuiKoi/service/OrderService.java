package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Koi;
import com.example.FengShuiKoi.entity.OrderDetail;
import com.example.FengShuiKoi.entity.Orders;
//import com.example.FengShuiKoi.entity.Koi;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.OrderDetailRequest;
import com.example.FengShuiKoi.model.OrderRequest;
import com.example.FengShuiKoi.repos.KoiRepository;
import com.example.FengShuiKoi.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AuthService authService;

    @Autowired
    KoiRepository koiRepository;

    public Orders create(OrderRequest orderRequest) {

        Account member = authService.getCurrentAccount();

        Orders order = new Orders();
        List<OrderDetail> orderDetails = new ArrayList<>();
        float total = 0;

        order.setMember(member);
        order.setDate(new Date());

        for (OrderDetailRequest orderDetailRequest : orderRequest.getDetail()) {

        Koi koi  = koiRepository.findKoiById(orderDetailRequest.getKoiId());

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(orderDetailRequest.getQuantity());
            orderDetail.setPrice(Float.parseFloat(koi.getPrice()));
            orderDetail.setKoi(koi);
            orderDetail.setOrderProduct(order);


            orderDetails.add(orderDetail);

            total += Float.parseFloat(koi.getPrice()) * orderDetailRequest.getQuantity();

        }
        order.setOrderDetails(orderDetails);
        order.setTotal(total);

        return orderRepository.save(order);

    }
    public List<Orders> getAll() {
        Account member = authService.getCurrentAccount();
        List<Orders> orders = orderRepository.findOrdersByMember(member);
        if (orders == null || orders.isEmpty()) {
            throw new EntityNotFoundException("No orders found for the current customer");
        }
        return orders;
    }

    public Orders get(UUID id) {
        Orders order = orderRepository.findOrdersById(id);
        if (order == null) {
            throw new EntityNotFoundException("Order not found");
        }
        return order;
    }
    public Orders update(UUID id, OrderRequest orderRequest) {
        Orders order = orderRepository.findOrdersById(id);
        List<OrderDetail> orderDetails = new ArrayList<>();
        float total = 0;
        for (OrderDetailRequest orderDetailRequest : orderRequest.getDetail()) {
            Koi koi = koiRepository.findKoiById(orderDetailRequest.getKoiId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(orderDetailRequest.getQuantity());
            orderDetail.setPrice(Float.parseFloat(koi.getPrice()));

            orderDetail.setKoi(koi);
            orderDetail.setOrderProduct(order);
            orderDetails.add(orderDetail);
            total += Float.parseFloat(koi.getPrice()) * orderDetailRequest.getQuantity();
        }
        order.setOrderDetails(orderDetails);
        order.setTotal(total);
        return orderRepository.save(order);
    }

    public void delete(UUID id) {
        Orders order = orderRepository.findOrdersById(id);
        orderRepository.delete(order);
    }
}
