package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.AccountResponse;
import com.example.FengShuiKoi.model.LoginRequest;
import com.example.FengShuiKoi.model.RegisterRequest;
import com.example.FengShuiKoi.repos.AccountRepository;
import jakarta.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    public AccountResponse register (RegisterRequest registerRequest) {

           Account account = modelMapper.map(registerRequest, Account.class);
        try {
            String originPassword = account.getPassword();
            account.setPassword(passwordEncoder.encode(originPassword));
            Account newAccount = accountRepository.save(account);

            return modelMapper.map(newAccount, AccountResponse.class);
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
    public AccountResponse login(LoginRequest loginRequest){
        try{
            Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            ));
            Account account=(Account) authentication.getPrincipal();
            AccountResponse accountResponse= modelMapper.map(account,AccountResponse.class);
            accountResponse.setToken(tokenService.generateToken(account));
            return accountResponse;
        }catch (Exception e){
            throw new EntityNotFoundException("Username or password invalid!");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findAccountByUsername(username);

    }
}

