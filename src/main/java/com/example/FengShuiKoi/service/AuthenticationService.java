package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.*;
import com.example.FengShuiKoi.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    TokenService tokenService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmailService emailService;


    public AccountResponse register(RegisterRequest registerRequest) {
        //map RegisterRequest => Account
        Account account= modelMapper.map(registerRequest,Account.class);
        try {
            String originPassword= account.getPassword();
            account.setPassword(passwordEncoder.encode(originPassword));
            Account newAccount = accountRepository.save(account);
            EmailDetail emailDetail= new EmailDetail();
            emailDetail.setReceiver(newAccount);
            emailDetail.setSubject("Welcome to FengShuiKoi");
            emailDetail.setLink("https://www.google.com/");
            emailService.sendEmail(emailDetail);
            return modelMapper.map(newAccount,AccountResponse.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains(account.getCode())) {
                throw new DuplicateEntity("Duplicate code!");
            } else if (e.getMessage().contains(account.getEmail())) {
                throw new DuplicateEntity("Duplication Email");
            } else {
                throw new DuplicateEntity("Duplication Phone!");
            }
        }
    }
    public List<Account> getAllAccount(){
        List<Account> accounts= accountRepository.findAll();
        return accounts;
    }

    @Autowired
    AuthenticationManager authenticationManager;

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
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        return accountRepository.findAccountByPhone(phone);
    }
    public Account getCurrentAccount(){
        Account account= (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return accountRepository.findAccountById(account.getId());
    }

    //Forgot Password
    public void forgotPassword(ForgotPasswordRequest forgotPasswordRequest){
        Account account= accountRepository.findAccountByEmail(forgotPasswordRequest.getEmail());
        if(account==null){
            throw new EntityNotFoundException("Account Not Found");

        }else{
            EmailDetail emailDetail= new EmailDetail();
            emailDetail.setReceiver(account);
            emailDetail.setSubject("Reset Password");
            emailDetail.setLink("https://blearning.vn/guide/swp/docker-local/?token=" +tokenService.generateToken(account));
            emailService.sendEmail(emailDetail);
        }
    }
    //Reset Password
    public void resetPassword(ResetPasswordRequest resetPasswordRequest){
        Account account= getCurrentAccount();
        account.setPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()));
        accountRepository.save(account);
    }
}
