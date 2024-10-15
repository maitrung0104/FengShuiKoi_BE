package com.example.FengShuiKoi.entity;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    @NotNull(message = "ID is mandatory")
    long id;

    @NotBlank(message = "Username is mandatory")
    String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    String phone;
}

