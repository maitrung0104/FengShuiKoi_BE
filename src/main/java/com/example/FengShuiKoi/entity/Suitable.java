package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Suitable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String s_element;
    @ManyToMany(mappedBy ="suitables" )
    Set<Element> elements;



}
