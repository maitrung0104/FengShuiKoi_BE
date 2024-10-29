package com.example.FengShuiKoi.model;

import lombok.Data;

import java.util.UUID;
@Data
public class OrderPlanDetailRequest {
    UUID planId;
    int quantity;
}

