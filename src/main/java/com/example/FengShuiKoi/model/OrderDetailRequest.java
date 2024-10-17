package com.example.FengShuiKoi.model;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDetailRequest {
    UUID koiId;
    int quantity;


}
