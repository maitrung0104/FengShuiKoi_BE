package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}