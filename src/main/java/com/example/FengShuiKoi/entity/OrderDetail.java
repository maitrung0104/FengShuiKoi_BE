package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int quantity;
    int price;
    int total;
    int createdBy;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderProduct orderProducts;

    @OneToMany(mappedBy = "orderDetail")
    List<Product> products;

}