package com.example.FengShuiKoi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    @NotNull(message = "ID is mandatory")
    long id;

    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 8 characters long")
    @Column(unique = true)
    String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})\\b" , message = "Invalid phone number")
    @Column(unique = true)
    String phone;
}

