package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pond")
public class KoiFishPond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String shape;


    @ManyToOne
    @JoinColumn(name = "ele_id")
    Element element;
}
