package com.example.FengShuiKoi.api;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.entity.RegisterPlan;
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.model.RegisterPlanRequest;
import com.example.FengShuiKoi.service.RegisterPlanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
@CrossOrigin("*")
@SecurityRequirement(name="api")
public class RegisterPlanAPI {
    @Autowired
    RegisterPlanService registerPlanService;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity create(@Valid @RequestBody RegisterPlanRequest planRequest ){
        RegisterPlan newPlan = registerPlanService.create(planRequest);

        return ResponseEntity.ok(newPlan);
    }

    @GetMapping
    public ResponseEntity getAllRegister() {
        List<RegisterPlan> registerPlans=registerPlanService.getAllRegisterPlan();
        return ResponseEntity.ok(registerPlans);
    }
    //api/student/{studentId}
    @PutMapping("{registerPlanID}")
    public ResponseEntity update(@PathVariable long registerPlanId,@Valid @RequestBody RegisterPlan registerPlan){
        RegisterPlan updatePlan= registerPlanService.update(registerPlanId,registerPlan);
        return ResponseEntity.ok(updatePlan);
    }
    @DeleteMapping("{registerPlanId}")
    public ResponseEntity delete(@PathVariable long registerPlanId){
        RegisterPlan deletedPlan=registerPlanService.delete(registerPlanId);
        return ResponseEntity.ok(deletedPlan);
    }
}

