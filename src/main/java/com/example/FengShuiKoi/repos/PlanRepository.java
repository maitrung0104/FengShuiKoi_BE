package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {

    Plan findProductById(UUID id);
    List<Plan> findProductsByIsDeletedFalse();
}
