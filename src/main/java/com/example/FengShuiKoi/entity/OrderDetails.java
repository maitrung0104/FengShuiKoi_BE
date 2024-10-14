package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int odId;

    int odQuantity;
    int odPrice;
    int odTotal;
    int odCreatedBy;
}
