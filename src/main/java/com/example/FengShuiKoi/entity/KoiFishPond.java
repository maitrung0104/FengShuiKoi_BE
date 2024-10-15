package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "koi_fish_pond")
public class KoiFishPond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

//    @ManyToOne
//    @JoinColumn(name = "element_id", referencedColumnName = "eleId")
//    Element element;
}