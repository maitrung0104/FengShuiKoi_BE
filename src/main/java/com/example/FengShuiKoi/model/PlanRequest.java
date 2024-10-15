package com.example.FengShuiKoi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlanRequest {

    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 0, message = "Price must be a positive number")
    int price;

    @NotBlank(message = "Description is mandatory")
    String description;
}
