package com.example.FengShuiKoi.model;

import lombok.Data;

@Data
public class AccountResponse {
    long id;
    String username;
    String password;
    String phone;
    String email;
    String token;

}
