package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.controller.Authentication;
import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.repos.AccountRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AccountRepository accountRepository;



    public Account register (Account account) {
        try {
            Account newAccount = accountRepository.save(account);

            return newAccount;
        } catch (Exception e) {
            if (e.getMessage().contains(account.getUsername())) {
                throw new DuplicateEntity("Duplicate username!");
            } else if (e.getMessage().contains(account.getEmail())) {
                throw new DuplicateEntity("Duplicate email!");
            } else {
                throw new DuplicateEntity("Duplicate phone!");
            }
        }
    }

        public List<Account> getAllAccount(){
            List<Account> accounts = accountRepository.findAll();
            return accounts;
        }

}
