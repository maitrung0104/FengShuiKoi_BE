package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 0, message = "Age should not be less than 0")
    @Max(value = 150, message = "Age should not be greater than 150")
    String age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})\\b", message = "Phone number is invalid")
    String phone;

    @NotBlank(message = "Address is mandatory")
    String address;

    @NotBlank(message = "Gender is mandatory")
    String gender;

    @Past
    @NotNull(message = "Date of birth in mandatory")
    LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Account account;











}