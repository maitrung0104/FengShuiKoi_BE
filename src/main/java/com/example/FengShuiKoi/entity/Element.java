package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String element_des;

    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<LakeDirection>lakeDirections;

    @ManyToMany
    @JoinTable(name = "element_suitable",
            joinColumns = @JoinColumn(name = "elemennt_id"),
            inverseJoinColumns = @JoinColumn(name = "suit_id")
    )
    Set<SuitableElement>suitableElements;




    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<KoiFishPond>koiFishPonds;

    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<Product> products;
}