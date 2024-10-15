package com.example.FengShuiKoi.controller;


import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Authentication {


    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Account account){
        Account newAccount = authService.register(account);
        return ResponseEntity.ok(newAccount);
    }

    @GetMapping("account")

    public ResponseEntity getAllAccount(){
        List<Account> accounts= authService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }
}
