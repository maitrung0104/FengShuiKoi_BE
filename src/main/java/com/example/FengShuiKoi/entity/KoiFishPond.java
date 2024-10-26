package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity

public class KoiFishPond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String shape;

    int pond_element;

    @ManyToOne
    @JoinColumn(name = "ele_id")
    Element element;

}
