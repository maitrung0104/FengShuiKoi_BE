package com.example.FengShuiKoi.api;


import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.model.*;
import com.example.FengShuiKoi.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@SecurityRequirement(name="api")
public class AuthenticationAPI {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequest registerRequest) {
        AccountResponse newAccount = authenticationService.register(registerRequest);
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
    @PostMapping("forgot-password")
    public ResponseEntity forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest){
        authenticationService.forgotPassword(forgotPasswordRequest);
        return ResponseEntity.ok("Forgot Password successfully");
    }
    @PostMapping("reset-password")
    public ResponseEntity resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest){
        authenticationService.resetPassword(resetPasswordRequest);
        return ResponseEntity.ok("Reset Password successfully");
    }

}
