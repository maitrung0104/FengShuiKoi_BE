package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LakeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String direction;

    @OneToOne
    @JoinColumn(name = "lake_element")
    Element element;
}
