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
@Table(name="direction")
public class LakeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String direction;


    @ManyToOne
    @JoinColumn(name = "ele_id")
    Element element;
}
