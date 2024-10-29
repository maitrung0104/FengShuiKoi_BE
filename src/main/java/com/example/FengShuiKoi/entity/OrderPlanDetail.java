package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class OrderPlanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    int quantity;
    float price;
    float total;

    @ManyToOne
    @JoinColumn(name = "op_id")
    @JsonIgnore
    OrderPlan orderPlan;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @JsonIgnore
    Plan plan;



}
