package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long pmId;
    String pmName;

//    @ManyToOne
//    @JoinColumn(name = "pay_id", referencedColumnName = "payId")
//    PaymentTotal paymentTotal;
//
//    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<OrderPlan> orderPlans;
}