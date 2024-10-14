package com.example.FengShuiKoi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    long id;
    String code;
    String email;
    String phone;
    String token;

}
