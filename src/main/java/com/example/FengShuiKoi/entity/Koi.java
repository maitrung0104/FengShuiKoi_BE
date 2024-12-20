package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity

public class Koi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UUID id;

    @JsonIgnore
    boolean isDeleted = false;


    String species;

    String colour;

    float size;

    int age;

    String origin;



    String image;

    String description;

    String element;
    String price;

    @Pattern(regexp = "P\\d{6}", message = "Koi code is not valid! ")
    String productCode;


    Timestamp createdAt;


    String createdBy;




    @OneToMany(mappedBy = "koi")
    @JsonIgnore
    List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    Account account;

//    @OneToMany(mappedBy = "koi", cascade = CascadeType.ALL)
//    @JsonIgnore
//    List<CartItem> cartItems;


//    @ManyToOne
//    @JoinColumn(name ="ele_id")
//    @JsonIgnore
//    Element element;




}
