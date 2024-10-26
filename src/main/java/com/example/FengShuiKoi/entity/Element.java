package com.example.FengShuiKoi.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> ce7b842a317ecb436374e78fb3107b52d1f09f51
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
<<<<<<< HEAD
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
=======

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


>>>>>>> ce7b842a317ecb436374e78fb3107b52d1f09f51
