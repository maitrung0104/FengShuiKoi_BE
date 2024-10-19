package com.example.FengShuiKoi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    Date date;

    float total;



    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    Account member;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
            @JsonIgnore
    List<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "orders")
            @JsonIgnore
    Payment payment;


}
