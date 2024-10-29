package com.example.FengShuiKoi.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderPlanRequest {
    List<OrderPlanDetailRequest> detail;
}
