package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.AccountResponse;
import com.example.FengShuiKoi.model.LoginRequest;
import com.example.FengShuiKoi.model.RegisterRequest;
import com.example.FengShuiKoi.repository.AccountRepository;
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
public class AuthenticationService implements UserDetailsService {
    @Autowired
    TokenService tokenService;
    @Autowired
    AccountRepository accountRepositoy;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ModelMapper modelMapper;

    public AccountResponse register(RegisterRequest registerRequest) {
        //map RegisterRequest => Account
        Account account= modelMapper.map(registerRequest,Account.class);
        try {
            String originPassword= account.getPassword();
            account.setPassword(passwordEncoder.encode(originPassword));
            Account newAccount = accountRepositoy.save(account);
            return modelMapper.map(newAccount,AccountResponse.class);
        } catch (Exception e) {
            if (e.getMessage().contains(account.getCode())) {
                throw new DuplicateEntity("Duplicate code!");
            } else if (e.getMessage().contains(account.getEmail())) {
                throw new DuplicateEntity("Duplication Email");
            } else {
                throw new DuplicateEntity("Duplication Phone");
            }
        }
    }
    public List<Account> getAllAccount(){
        List<Account> accounts= accountRepositoy.findAll();
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
        return accountRepositoy.findAccountByPhone(phone);
    }
}
