package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.repos.AccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import io.jsonwebtoken.security.Keys;
@Service
public class TokenService {
    @Autowired
    AccountRepository accountRepository;
    public final String SECRET_KEY="4bb6d1absacx64a681139d1586b6f1160d18159afd57c8c79136d7490630407sa";
    private SecretKey getSigninKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateToken(Account account){
        String token = Jwts.builder()
                .subject(account.getId()+"")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                //1000(1giay) * 60(1phut) * 60(1gio) * 24(1ngay)
                .signWith(getSigninKey())
                .compact();
        return token;
    }
    //verify token
    public Account getAccountByToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String idString= claims.getSubject();
        long id= Long.parseLong(idString);
        return accountRepository.findAccountById(id);
    }

}


