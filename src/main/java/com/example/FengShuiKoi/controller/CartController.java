package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Cart;
import com.example.FengShuiKoi.service.CartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
@SecurityRequirement(name = "api")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<Cart> getCart(@RequestParam Long cartId) {
        Cart cart = cartService.getCart(cartId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long cartId, @RequestParam UUID koiID, @RequestParam int quantity) {
        Cart cart = cartService.addToCart(cartId, koiID, quantity);
        return ResponseEntity.ok(cart);
    }
    @DeleteMapping
    public ResponseEntity<Void> removeFromCart(@RequestParam Long cartId, @RequestParam UUID koiID) {
        cartService.delete(cartId, koiID);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<Cart> updateCart(@RequestParam Long cartId, @RequestParam UUID koiID, @RequestParam int quantity) {
        Cart cart = cartService.updateCart(cartId, koiID, quantity);
        return ResponseEntity.ok(cart);
    }

}