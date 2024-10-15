package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "plan_feng")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int plId;
    String plName;
    int plPrice;
    String plDescription;

    @OneToMany(mappedBy = "plan")
    List<User> users;
//    @OneToMany(mappedBy = "plan")
//    List<OrderPlan> orderPlan;

}