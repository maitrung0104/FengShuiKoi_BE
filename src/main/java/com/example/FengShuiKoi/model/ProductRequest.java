package com.example.FengShuiKoi.model;


import com.example.FengShuiKoi.entity.Enum.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductRequest {

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
    String p_element;

    @NotBlank(message = "Description can not be blank")
    String description;

    @NotBlank(message = "price can not be blank")
    String price;

    @Pattern(regexp = "P\\d{6}", message = "Product code is not valid! ")
    String productCode;


    Timestamp createdAt;


    String createdBy;


    @Enumerated(EnumType.STRING)
    Category category;

}
