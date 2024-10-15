package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "element_feng")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int eleId;

    String element;

    @OneToOne(mappedBy = "element")
    User user;

//    @OneToMany(mappedBy = "element")
//    List<Product> products;

//    @ManyToMany
//    @JoinTable(
//            name = "suitable_element",
//            joinColumns = @JoinColumn(name = "ele_id"),
//            inverseJoinColumns = @JoinColumn(name = "sui_element")
//    )
//    List<Element> suitableElements;
//
//    @ManyToMany(mappedBy = "suitableElements")
//    List<Element> compatibleElements;
//
//    @OneToOne(mappedBy = "element")
//    Direction direction;
//
//    @OneToOne(mappedBy = "element")
//    KoiFishPond koiFishPond;
}