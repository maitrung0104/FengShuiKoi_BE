package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Date orderdate;
    int quantity;
    int total;
    int paymentmethod;

    @OneToOne(mappedBy = "invoice")
    PaymentMethod paymentMethod;

    @OneToOne(mappedBy = "invoice")
    User user;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    PaymentTotal paymentTotal;

}
