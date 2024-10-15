package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "payment_total")
public class PaymentTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int payId;

    @Column(name = "order_id", insertable = false, updatable = false)
    int orderId;

    int amount;
    Date payDate;
    int payMethod;

    @Enumerated(EnumType.STRING)
    PaymentStatus payStatus;

//    @OneToMany(mappedBy = "paymentTotal", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<PaymentMethod> payment;
//
//    @OneToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "ordId")
//    OrderProduct order;
//
//    @OneToOne
//    @JoinColumn(name = "order_plan_id", referencedColumnName = "opId")
//    OrderPlan orderPlan;
}