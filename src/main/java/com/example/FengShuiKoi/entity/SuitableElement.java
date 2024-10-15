package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "suitable_element")
public class SuitableElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    int eleId;

    int suiElement;
}