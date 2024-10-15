package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "order_plan")
public class OrderPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int opId;

    @Column(name = "op_uid")
    int opUid;

    @Column(name = "op_pid", insertable = false, updatable = false)
    int opPid;

    Date opOrderDate;
    int opQuantity;
    int opTotal;
    int opPaymentMethod;

//    @ManyToOne
//    @JoinColumn(name = "op_paymentmethod", referencedColumnName = "pmId")
//    PaymentMethod paymentMethod;
//
//    @OneToOne
//    @JoinColumn(name = "op_uid", referencedColumnName = "id") // Corrected column name
//    User user;

//    @OneToOne(mappedBy = "orderPlan", cascade = CascadeType.ALL, orphanRemoval = true)
//    PaymentTotal paymentTotal;
//
//    @ManyToOne
//    @JoinColumn(name = "op_pid", referencedColumnName = "plId")
//    Plan plan;
//}
}