package com.example.FengShuiKoi.entity;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 0, message = "Age should not be less than 0")
    @Max(value = 150, message = "Age should not be greater than 150")
    String age;


    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    String phone;

    @NotBlank(message = "Address is mandatory")
    String address;

    @NotBlank(message = "Gender is mandatory")
    String gender;


    @Past @NotNull(message = "Date of birth in mandatory")
    LocalDate dateOfBirth;
}
