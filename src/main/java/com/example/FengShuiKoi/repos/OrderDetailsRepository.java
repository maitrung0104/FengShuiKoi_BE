package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}