package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Cart;
import com.example.FengShuiKoi.entity.CartItem;
import com.example.FengShuiKoi.entity.Koi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci FROM CartItem ci WHERE ci.cart = :cart AND ci.koi = :koi")
    CartItem findCartItemByCartAndKoi(@Param("cart") Cart cart, @Param("koi") Koi koi);
    // Add custom query methods if needed
}