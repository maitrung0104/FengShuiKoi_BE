package com.example.FengShuiKoi.entity;

<<<<<<< HEAD
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
=======
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
>>>>>>> origin/forgot-password
