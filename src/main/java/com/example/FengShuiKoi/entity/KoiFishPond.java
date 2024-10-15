package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

=======
import lombok.Data;

@Entity
@Data
@Table(name = "koi_fish_pond")
>>>>>>> origin/forgot-password
public class KoiFishPond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

<<<<<<< HEAD
    String shape;

    int pond_element;

    @OneToOne(mappedBy = "koiFishPond")
    Element element;
}
=======
    String name;

//    @ManyToOne
//    @JoinColumn(name = "element_id", referencedColumnName = "eleId")
//    Element element;
}
>>>>>>> origin/forgot-password
