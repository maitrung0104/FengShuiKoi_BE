package com.example.FengShuiKoi.model;

import com.example.FengShuiKoi.entity.Enum.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateAccountRequest {
    String username;
    String email;
    String phone;
    String password;
    String name;
    String gender;
    LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    Role role;
}
