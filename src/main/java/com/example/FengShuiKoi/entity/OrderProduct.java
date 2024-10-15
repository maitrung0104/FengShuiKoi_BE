package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ordId;

    String ordTotal;

    @Enumerated(EnumType.STRING)
    PaymentStatus ordStatus;

//    @OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<OrderDetails> orderDetails;
//
//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    PaymentTotal paymentTotal;
}