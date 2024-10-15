package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
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
