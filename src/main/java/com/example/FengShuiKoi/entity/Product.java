package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @NotBlank(message = "Size can not be blank")
    float size;
    @NotBlank(message = "age can not be blank")
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
