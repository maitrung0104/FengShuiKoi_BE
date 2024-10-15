package com.example.FengShuiKoi.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserRequest {
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

}
