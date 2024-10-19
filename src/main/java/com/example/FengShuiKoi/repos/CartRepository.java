package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Add custom query methods if needed
}