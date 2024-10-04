package com.example.FengShuiKoi.api;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.model.AccountResponse;
import com.example.FengShuiKoi.model.LoginRequest;
import com.example.FengShuiKoi.model.RegisterRequest;
import com.example.FengShuiKoi.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name="api")
public class AuthenticationAPI {

    //DI: Dependency injection
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequest registerRequest){
        AccountResponse newAccount =authenticationService.register(registerRequest);
        return ResponseEntity.ok(newAccount);

    }
    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest){
        AccountResponse newAccount= authenticationService.login(loginRequest);
        return ResponseEntity.ok(newAccount);
    }
    @GetMapping("account")
    public ResponseEntity getAllAccount(){
        List<Account> accounts= authenticationService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }
}

