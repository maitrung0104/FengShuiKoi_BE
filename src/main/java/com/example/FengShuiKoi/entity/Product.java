package com.example.FengShuiKoi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
    boolean isDeleted = false;
    @NotBlank(message = "Species can not be blank")
    String species;
    @NotBlank(message = "colour can not be blank")
    String colour;

    float size;

    int age;
    @NotBlank(message = "Origin can not be blank")
    String origin;

    @NotBlank(message = "Description can not be blank")
    String description;
    float price;
    @Pattern(regexp = "P\\d{6}", message = "Product code is not valid! ")
    String productCode;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name="element_id")
    Element element;
}
