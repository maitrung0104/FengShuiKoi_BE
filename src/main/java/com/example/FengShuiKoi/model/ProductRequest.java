package com.example.FengShuiKoi.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Species can not be blank")
    String species;
    @NotBlank(message = "colour can not be blank")
    String colour;
    @Min(value = 1)
    @Max(value = 10)
    float size;
    @Min(value = 1)
    @Max(value = 10)
    int age;
    @NotBlank(message = "Origin can not be blank")
    String origin;
    @NotBlank(message = "Element can not be blank")
    String element;
    @NotBlank(message = "Description can not be blank")
    String description;
    @Min(value=0, message = "Score must be at least 0!")
    @Max(value = 500,message = "Score must be more than 10!")
    float price;
    @Pattern(regexp = "P\\d{6}", message = "Product code is not valid! ")
    String productCode;
}
