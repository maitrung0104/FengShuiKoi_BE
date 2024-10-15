package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
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
=======
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
>>>>>>> origin/forgot-password
