package com.example.FengShuiKoi.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class UserRequest {


    String name;


    String age;


    String email;


    String phone;


    String address;


    String gender;


    LocalDate dateOfBirth;

}
