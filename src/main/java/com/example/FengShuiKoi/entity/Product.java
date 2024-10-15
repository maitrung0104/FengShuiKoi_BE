package com.example.FengShuiKoi.entity;

import com.example.FengShuiKoi.entity.Enum.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

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


    String species;


    String colour;


    float size;


    int age;


    String origin;


    String p_element;


    String description;


    String price;

    @Pattern(regexp = "P\\d{6}", message = "Product code is not valid! ")
    String productCode;


    Timestamp createdAt;


    String createdBy;


    @Enumerated(EnumType.STRING)
    Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "element_id")
    Element element;

    @ManyToOne
    @JoinColumn(name = "OrderDetail_id")
    OrderDetail orderDetail;





}





