package com.example.FengShuiKoi.controller;


import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Authentication {


    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public String register(@Valid @RequestBody Account account){
        Account newAccount = authService.register(account);
        return "Register success";
    }

}
