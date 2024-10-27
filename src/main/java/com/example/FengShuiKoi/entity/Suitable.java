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

//    @ManyToMany(mappedBy = "suitables")
//    Set<Element> elements;
    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element; // Mệnh

    @ManyToOne
    @JoinColumn(name = "suitable_element_id")
    private Element suitableElement; // Mệnh thích hợp


}
