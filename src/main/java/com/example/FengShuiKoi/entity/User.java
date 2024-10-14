package com.example.FengShuiKoi.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "Can not be blank!!")

    String name;
    @Pattern(regexp="(84|0[3|5|7|8|9])+(\\d{8})",message = "Phone invalid")

    String phone;
    @NotBlank(message = "Can not be blank!!")

    String email;
    @NotBlank(message = "Can not be blank!!")
    String gender;
    @Past
    @NotNull(message = "Can not be blank!!")
    LocalDate dob;



}
