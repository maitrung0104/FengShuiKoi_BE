package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String element;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "element")
    List<Product> productList;

    @OneToMany(mappedBy = "element")
    List<Suitable> suitableList;

    @OneToOne
    @JoinColumn(name = "LakeDirection_id")
    LakeDirection lakeDirection;

    @OneToOne
    @JoinColumn(name = "Pond_id")
    KoiFishPond koiFishPond;
}
=======
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
>>>>>>> origin/forgot-password
