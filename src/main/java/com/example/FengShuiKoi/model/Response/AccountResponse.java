package com.example.FengShuiKoi.model.Response;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Enum.Role;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AccountResponse {
    long id;
    String username;
    String password;
    String name;
    String gender;
    LocalDate dateOfBirth;
    String phone;
    String email;
    String token;
    List<Account> content;
    int pageNumber;
    int totalElements;
    int totalPages;
    Role role;

}

