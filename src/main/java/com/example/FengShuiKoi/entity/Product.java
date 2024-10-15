package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    long id;

    @JsonIgnore
    boolean isDeleted= false;
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
    String element;
    @NotBlank(message = "Description can not be blank")
    String Description;
    @NotBlank(message = "price can not be blank")
    String price;
    @Pattern(regexp = "P\\d{6}",message = "Product code is not valid! ")
    String productCode;
}
