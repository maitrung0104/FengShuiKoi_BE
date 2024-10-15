package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import lombok.Getter;
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

    @OneToOne(mappedBy = "koiFishPond")
    Element element;
}
