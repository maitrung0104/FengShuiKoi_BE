package com.example.FengShuiKoi.repository;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.entity.RegisterPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterPlanRepository extends JpaRepository<RegisterPlan,Long> {
    RegisterPlan findRegisterPlanById(long id);
    List<RegisterPlan> findRegisterPlanByIsDeletedFalse();

}
