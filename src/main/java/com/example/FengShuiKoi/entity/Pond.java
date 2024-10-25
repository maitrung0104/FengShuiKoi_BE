package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Pond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String shape;

    @OneToOne
    @JoinColumn(name = "pond_element")
    Element element;




}
