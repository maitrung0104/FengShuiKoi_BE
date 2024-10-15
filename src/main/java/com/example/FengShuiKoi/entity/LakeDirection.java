package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LakeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String direction;

    int lake_element;

    @OneToOne(mappedBy = "lakeDirection")
    Element element;
}
