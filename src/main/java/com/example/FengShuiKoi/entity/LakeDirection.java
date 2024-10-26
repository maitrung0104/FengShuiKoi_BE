package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
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
    int id;

    String direction;

    int lake_element;
    @ManyToOne
    @JoinColumn(name = "ele_id")
    Element element;

=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LakeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String direction;

    @OneToOne
    @JoinColumn(name = "lake_element")
    Element element;
>>>>>>> ce7b842a317ecb436374e78fb3107b52d1f09f51
}
