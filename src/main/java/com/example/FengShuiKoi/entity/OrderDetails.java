package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int odId;

    int odQuantity;
    int odPrice;
    int odTotal;
    int odCreatedBy;

//    @Column(name = "od_oid", insertable = false, updatable = false)
//    int odOid;
//
//    @Column(name = "od_pid", insertable = false, updatable = false)
//    int odPid;
//
//    @ManyToOne
//    @JoinColumn(name = "od_pid", referencedColumnName = "id")
//    Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "od_oid", referencedColumnName = "ordId")
//    OrderProduct orderProduct;
}