package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "order_plan")
public class OrderPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Date opOrderDate;
    int opQuantity;
    int opTotal;
    int opPaymentMethod;
}
