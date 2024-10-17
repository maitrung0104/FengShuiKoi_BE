//package com.example.FengShuiKoi.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import java.util.List;
//
//@Entity
//@Data
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<CartItem> items;
//
//    // Add other fields like user reference if needed
//}