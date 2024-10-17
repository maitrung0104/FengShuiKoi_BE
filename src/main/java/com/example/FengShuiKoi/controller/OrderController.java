package com.example.FengShuiKoi.controller;

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
    public ResponseEntity createOrder(@RequestBody OrderRequest orderRequest){
        Orders orderProduct = orderService.create(orderRequest);
        return ResponseEntity.ok(orderProduct);
    }
    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

}
