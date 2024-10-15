package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String total;

    @Enumerated(EnumType.STRING)
    PaymentStatus status;

    @OneToMany(mappedBy = "orderProducts")
    List<OrderDetail> orderDetails;


    @OneToOne
    @JoinColumn(name = "order_id")
    PaymentTotal paymentTotal;


}
