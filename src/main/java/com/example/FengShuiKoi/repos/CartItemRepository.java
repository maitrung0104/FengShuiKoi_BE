package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Add custom query methods if needed
}