package com.example.FengShuiKoi.model.Response;

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
