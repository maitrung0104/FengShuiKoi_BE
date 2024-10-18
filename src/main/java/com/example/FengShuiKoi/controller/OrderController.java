package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Orders;
import com.example.FengShuiKoi.model.OrderRequest;
import com.example.FengShuiKoi.repos.OrderRepository;
import com.example.FengShuiKoi.service.AuthService;
import com.example.FengShuiKoi.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity create(@RequestBody OrderRequest orderRequest) throws Exception {
        String vnPayURL  = orderService.createUrl(orderRequest);
        return ResponseEntity.ok(vnPayURL);
    }
    @GetMapping
    public ResponseEntity get(){
        Account account = authService.getCurrentAccount();
        List<Orders> orders = orderRepository.findOrdersByMember(account);
        return ResponseEntity.ok(orders);
    }
    @PostMapping("/transaction")
    public ResponseEntity createTransaction(@RequestParam UUID orderID) {
        orderService.createTransaction(orderID);
        return ResponseEntity.ok("success");
    }

}
