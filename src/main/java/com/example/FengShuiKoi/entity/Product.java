package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_feng")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    long id;

    @JsonIgnore
    boolean isDeleted = false;

    @NotBlank(message = "Species can not be blank")
    String species;

    @NotBlank(message = "colour can not be blank")
    String colour;

    @NotNull(message = "Size can not be null")
    float size;

    @NotNull(message = "age can not be null")
    int age;

    @NotBlank(message = "Origin can not be blank")
    String origin;

    @NotBlank(message = "Element can not be blank")
    @Column(insertable = false, updatable = false)
    String element;

    @NotBlank(message = "Description can not be blank")
    String p_Description;

    @NotBlank(message = "price can not be blank")
    String price;

    @Pattern(regexp = "P\\d{6}", message = "Product code is not valid! ")
    String productCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

//    @ManyToOne
//    @JoinColumn(name = "p_element", referencedColumnName = "eleId")
//    Element element;
}
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<OrderDetails> orderDetails;




