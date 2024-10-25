package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Suitable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    @ManyToMany(mappedBy = "suitables")

    List<Element> elements;
}
