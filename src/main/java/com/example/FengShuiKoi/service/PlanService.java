package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Enum.Role;
import com.example.FengShuiKoi.entity.Plan;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.PlanRequest;
import com.example.FengShuiKoi.repos.AccountRepository;
import com.example.FengShuiKoi.repos.PlanRepository;
import org.hibernate.annotations.Array;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthService authService;

    @Autowired
    AccountRepository accountRepository;

    // CREATE
    public Plan createPlan(PlanRequest planRequest) {
        try {

            Plan plan = modelMapper.map(planRequest, Plan.class);
            Plan newPlan = planRepository.save(plan);
            return newPlan;
        } catch (Exception e) {
            throw new EntityNotFoundException("Duplicate name");
        }

    }
    // READ
    public List<Plan> getAllPlans() {
        List<Plan>plans=planRepository.findProductsByIsDeletedFalse()   ;
        return plans;
    }

    public Plan getPlanById(long id) {
        Plan oldPlan = planRepository.findProductById(id);
        if(oldPlan ==null) throw new EntityNotFoundException("Product not found !");


        return oldPlan;
    }
        //UPDATE

    public Plan updatePlan(long id,PlanRequest planRequest){
        //Buoc 1 Tìm ra thằng Plan càn được update thông qua id
        Plan oldPlan= planRepository.findProductById(id);





        if(oldPlan== null) throw new EntityNotFoundException("Plan not Found!");

        modelMapper.map(planRequest, oldPlan);
        //=> co ton tai
        // Buoc 2 cập nhật thông tin
        oldPlan.setName(planRequest.getName());
        oldPlan.setPrice(planRequest.getPrice());
        oldPlan.setDescription(planRequest.getDescription());
        // Bước 3 lưu db
        return planRepository.save(oldPlan);

    }
    //DELETE
    public Plan deletePlan(long id){
        Plan oldPlan=planRepository.findProductById(id);
        if(oldPlan ==null) throw new EntityNotFoundException("Plan not found");
        oldPlan.setDeleted(true);
        return planRepository.save(oldPlan);

    }
    // Purchase Plan



}



