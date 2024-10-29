package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class OrderPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    Date date;

    float total;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    Account member;

    @OneToMany(mappedBy = "orderPlan", cascade = CascadeType.ALL)
    @JsonIgnore
    List<OrderPlanDetail> orderDetailPlans;

    @OneToOne(mappedBy = "orderPlan")
    @JsonIgnore
    Payment payment;

}
