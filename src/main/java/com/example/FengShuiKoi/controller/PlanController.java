package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Plan;
import com.example.FengShuiKoi.model.PlanRequest;
import com.example.FengShuiKoi.service.PlanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
@PreAuthorize("hasAuthority('ADMIN')")
public class PlanController {

    @Autowired
    PlanService planService;


    @PostMapping
    public ResponseEntity createPlan(@Valid @RequestBody PlanRequest plan){
        Plan newPlan = planService.createPlan(plan);
        return ResponseEntity.ok(newPlan);
    }


    @GetMapping
    public ResponseEntity getAllPlans() {
        List<Plan> plans = planService.getAllPlans();
        return ResponseEntity.ok(plans);
    }


    @GetMapping("{planId}")
    public ResponseEntity getPlanById(@PathVariable UUID planId) {
        Plan plan = planService.getPlanById(planId);
        return ResponseEntity.ok(plan);
    }


    @PutMapping("{planId}")
    public ResponseEntity update(@PathVariable UUID planId, @Valid @RequestBody PlanRequest planRequest){
        Plan updatedPlan = planService.updatePlan(planId, planRequest);
        return ResponseEntity.ok(updatedPlan);
    }


    @DeleteMapping("{planId}")
    public ResponseEntity deletedPlan(@PathVariable UUID planId){
        Plan deletePlan = planService.deletePlan(planId);
        return ResponseEntity.ok(deletePlan);
    }
}