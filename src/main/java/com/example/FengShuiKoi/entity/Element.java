package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import java.util.Set;

@Getter
@Setter
@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String element;

    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<KoiFishPond>koiFishPonds;

    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<LakeDirection> lakeDirections;

    @ManyToMany
    @JoinTable(name = "elements",
            joinColumns = @JoinColumn(name = "element_id"),
            inverseJoinColumns = @JoinColumn(name = "suit_id")
    )
    Set<Suitable> suitables;
}
