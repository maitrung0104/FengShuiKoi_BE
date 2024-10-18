package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
