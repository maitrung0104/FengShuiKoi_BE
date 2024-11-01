package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @JsonIgnore
    boolean isDeleted = false;


    String name;

    @Min(value = 0)
    int price;


    String description;



    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany(mappedBy = "plan")
    List<Account> accounts;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    List<OrderPlanDetail> orderPlanDetails;

    @OneToMany(mappedBy = "plan")
    List<Payment> payments;

}
