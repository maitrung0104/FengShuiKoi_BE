package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonIgnore
    boolean isDeleted = false;


    String name;


    int price;


    String description;

    @OneToMany(mappedBy = "plan")
    List<User> userList;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    PaymentTotal paymentTotal;

    @Enumerated(EnumType.STRING)
    Role role;
}
