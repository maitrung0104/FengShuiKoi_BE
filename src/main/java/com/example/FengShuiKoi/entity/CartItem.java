package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int quantity;

    String image;
    @ManyToOne
    @JoinColumn(name = "cart_id")
            @JsonIgnore
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "koi_id")
            @JsonIgnore
    Koi koi;
}
