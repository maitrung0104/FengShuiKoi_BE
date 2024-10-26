package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
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



=======
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Suitable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    @ManyToMany(mappedBy = "suitables")

    List<Element> elements;
>>>>>>> ce7b842a317ecb436374e78fb3107b52d1f09f51
}
