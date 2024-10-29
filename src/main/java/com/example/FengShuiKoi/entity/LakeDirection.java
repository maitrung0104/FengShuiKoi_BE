package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LakeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String direction;


    @ManyToOne
    @JoinColumn(name = "ele_id")
    Element element;

}