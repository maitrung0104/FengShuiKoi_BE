package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.OrderPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderPlanRepository extends JpaRepository<OrderPlan, UUID> {
    OrderPlan findOrderPlanById(UUID id);
    List<OrderPlan> findOrderPlanByMember(Account Member);
}
