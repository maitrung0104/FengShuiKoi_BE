package com.example.FengShuiKoi.controller;


import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.model.*;
import com.example.FengShuiKoi.model.Response.AccountResponse;
import com.example.FengShuiKoi.service.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "api")

public class Authentication {


    @Autowired
    AuthService authService;
    @PostMapping("/register")

    public ResponseEntity register(@Valid @RequestBody RegisterRequest registerRequest){
        AccountResponse newAccount = authService.register(registerRequest);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping("login")

    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest){
        AccountResponse newAccount = authService.login(loginRequest);
        return ResponseEntity.ok(newAccount);
    }


    @GetMapping("account")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity getAllAccount(
            @RequestParam int page,
            @RequestParam(defaultValue = "5") int size){
        AccountResponse accounts = authService.getAllAccount(page, size);
        return ResponseEntity.ok(accounts);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity forgotPassword(@Valid @RequestBody ForgotPassword forgotPassword) {
        authService.forgotPassword(forgotPassword.getEmail());
        return ResponseEntity.ok("Check your email to confirm reset password");
    }
    @PostMapping("/reset-password")
    public ResponseEntity resetPassword(@Valid @RequestBody ResetPassword resetPassword) {
        authService.resetPassword(resetPassword);
        return ResponseEntity.ok("Password reset successfully");
    }
    @PutMapping("/account/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity updateAccount(@PathVariable Long id, @Valid @RequestBody UpdateAccountRequest updateAccountRequest) {
        AccountResponse updatedAccount = authService.updateAccount(id, updateAccountRequest);
        return ResponseEntity.ok(updatedAccount);
    }
    @PostMapping("/logout")
    public ResponseEntity logout() {
        authService.logout();
        return ResponseEntity.ok("Logged out successfully");
    }

}
