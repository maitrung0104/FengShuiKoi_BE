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


    String name;


    String age;


    String email;


    String phone;


    String address;


    String gender;


    LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Account account;











}