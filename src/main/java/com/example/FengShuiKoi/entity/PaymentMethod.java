package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "payment_total_id")
    PaymentTotal paymentTotal;


    @OneToOne
    @JoinColumn(name = "invoice_id")
    Invoice invoice;



}
