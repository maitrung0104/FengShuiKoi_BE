package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.PaymentEnums;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Date createAt;

    @Enumerated(EnumType.STRING)
    PaymentEnums payment_method;


    @OneToOne
    @JoinColumn(name = "order_id")
    Orders orders;

    @OneToOne
    @JoinColumn(name = "op_id")
    OrderPlan orderPlan;


    @ManyToOne
    @JoinColumn(name = "plan_id")
    Plan plan;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    Set<Transactions> transactions;


}
