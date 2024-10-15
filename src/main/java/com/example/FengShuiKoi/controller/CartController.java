package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Cart;
import com.example.FengShuiKoi.service.CartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@SecurityRequirement(name = "api")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam int quantity) {
        Cart cart = cartService.addToCart(cartId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
}