package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
