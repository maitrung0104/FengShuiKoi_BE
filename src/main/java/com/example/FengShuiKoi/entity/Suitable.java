package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Suitable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String s_element;

    @ManyToOne
    @JoinColumn(name = "element_id")
    Element element;


}
