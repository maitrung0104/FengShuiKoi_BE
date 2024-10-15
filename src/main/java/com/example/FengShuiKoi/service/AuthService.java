package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public Account register (Account account){

        boolean isDuplicate = false;
        if(isDuplicate){
            throw new DuplicateEntity("Duplicate username");
        }
        return account;
    }
}
