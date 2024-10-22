package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String content;
    int rating;

    @ManyToOne
    @JoinColumn(name = "member_id")
            @JsonIgnore
    Account member;

    @ManyToOne
    @JoinColumn(name = "shop_id")
            @JsonIgnore
    Account shop;
}
