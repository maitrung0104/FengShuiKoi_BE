package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lake_direction")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int directId;

    String direction;

//    @OneToOne
//    @JoinColumn(name = "lake_element", referencedColumnName = "eleId")
//    Element element;
}