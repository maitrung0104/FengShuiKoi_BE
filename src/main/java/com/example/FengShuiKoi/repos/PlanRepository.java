package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    Plan findProductById(long id);
    List<Plan> findProductsByIsDeletedFalse();
}
=======
public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
>>>>>>> origin/forgot-password
