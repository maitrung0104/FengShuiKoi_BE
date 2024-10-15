package com.example.FengShuiKoi.controller;


import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.model.AccountResponse;
import com.example.FengShuiKoi.model.ForgotPassword;
import com.example.FengShuiKoi.model.LoginRequest;
import com.example.FengShuiKoi.model.RegisterRequest;
import com.example.FengShuiKoi.service.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity getAllAccount(){
        List<Account> accounts= authService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity forgotPassword(@Valid @RequestBody ForgotPassword forgotPassword) {
        authService.forgotPassword(forgotPassword.getEmail());
        return ResponseEntity.ok("Check your email to confirm reset password");
    }
}
