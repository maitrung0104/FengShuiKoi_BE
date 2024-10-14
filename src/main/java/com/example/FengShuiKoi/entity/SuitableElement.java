package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.interfaces.ECKey;
import java.util.Set;

@Entity
@Getter
@Setter
public class SuitableElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    @ManyToMany(mappedBy ="suitableElements" )
    Set<Element>elements;

}
