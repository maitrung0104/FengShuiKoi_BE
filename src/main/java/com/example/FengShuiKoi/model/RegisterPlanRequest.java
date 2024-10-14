package com.example.FengShuiKoi.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPlanRequest {
    @NotBlank(message = "Species can not be blank")
    String name;
    @Min(value=0, message = "Score must be at least 0!")
    @Max(value = 500,message = "Score must be more than 10!")
    float price;
    @NotBlank(message = "Description can not be blank")
    String description;
}
