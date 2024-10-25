package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;



    @OneToOne(mappedBy = "element")
    LakeDirection lakeDirection;

    @OneToOne(mappedBy = "element")
    Pond pond;

    @ManyToMany
    @JoinTable(
            name = "Suitable_Element",
            joinColumns = @JoinColumn(name = "ele_id"),
            inverseJoinColumns = @JoinColumn(name = "sui_element")
    )
    List<Suitable > suitables;
}


