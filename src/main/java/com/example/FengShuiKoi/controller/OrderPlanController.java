package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.OrderPlan;
import com.example.FengShuiKoi.entity.Orders;
import com.example.FengShuiKoi.entity.Transactions;
import com.example.FengShuiKoi.model.OrderPlanRequest;
import com.example.FengShuiKoi.model.OrderRequest;
import com.example.FengShuiKoi.repos.OrderPlanRepository;
import com.example.FengShuiKoi.repos.OrderRepository;
import com.example.FengShuiKoi.service.AuthService;
import com.example.FengShuiKoi.service.OrderPlanService;
import com.example.FengShuiKoi.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orderPlan")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class OrderPlanController {
    @Autowired
    OrderPlanService orderPlanService;

    @Autowired
    OrderPlanRepository orderPlanRepository;

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity create(@RequestBody OrderPlanRequest orderPlanRequest) throws Exception {
        String vnPayURL  = orderPlanService.createUrl(orderPlanRequest);
        return ResponseEntity.ok(vnPayURL);
    }
    @GetMapping
    public ResponseEntity get(){
        Account account = authService.getCurrentAccount();
        List<OrderPlan> orders = orderPlanRepository.findOrderPlanByMember(account);
        return ResponseEntity.ok(orders);
    }
    @PostMapping("/transaction")
    public ResponseEntity createTransaction(@RequestParam UUID orderID) {
        orderPlanService.createTransaction(orderID);
        return ResponseEntity.ok("success");
    }

}
