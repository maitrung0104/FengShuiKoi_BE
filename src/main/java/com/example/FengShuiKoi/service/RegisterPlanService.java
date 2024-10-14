package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.entity.RegisterPlan;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.model.RegisterPlanRequest;
import com.example.FengShuiKoi.model.RegisterRequest;
import com.example.FengShuiKoi.repository.RegisterPlanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterPlanService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    RegisterPlanRepository registerPlanRepository;
    //CREATE
    public RegisterPlan create( RegisterPlanRequest registerPlanRequest) {
        try {
             RegisterPlan registerPlan   = modelMapper.map(registerPlanRequest, RegisterPlan.class);
            Account accountRequest = authenticationService.getCurrentAccount();
           // registerPlan.setAccount(accountRequest); //set thong tin student cua account nay

            RegisterPlan newRegisterPlan = registerPlanRepository.save(registerPlan);
            return newRegisterPlan;
        }catch (Exception e) {
            throw new DuplicateEntity("Duplication plan code");

        }
    }
    //READ
    public List<RegisterPlan> getAllRegisterPlan(){
        List<RegisterPlan>registerPlans=registerPlanRepository.findRegisterPlanByIsDeletedFalse()   ;
        return registerPlans;
    }
    //UPDATE
    public RegisterPlan update(long id,RegisterPlan registerPlan){
        //Buoc 1 Tìm ra thằng student càn được update thông qua id
        RegisterPlan oldPlan= registerPlanRepository.findRegisterPlanById(id);

        if(oldPlan== null) throw new EntityNotFoundException("Plan not Found!");
        //=> cos ton tai
        // Buoc 2 cập nhật thông tin
        oldPlan.setName(registerPlan.getName());
        oldPlan.setPrice(registerPlan.getPrice());
        oldPlan.setDescription(registerPlan.getDescription());
        // Bước 3 lưu db
        return registerPlanRepository.save(oldPlan);
    }
    //DELETE
    public RegisterPlan delete(long id){
        RegisterPlan oldPlan=registerPlanRepository.findRegisterPlanById(id);
        if(oldPlan ==null) throw new EntityNotFoundException("Product not found");
        oldPlan.setDeleted(true);
        return registerPlanRepository.save(oldPlan);
    }
    public RegisterPlan getRegisterPlanById(long id){
        RegisterPlan oldPlan= registerPlanRepository.findRegisterPlanById(id);
        if(oldPlan==null) throw new EntityNotFoundException("Product not found !");
        //if user.status== "BLOCK" => throw new EntityNotFoundException("Student not found!");
        return oldPlan;
    }
}