package com.example.FengShuiKoi.repository;

import com.example.FengShuiKoi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByPhone(String phone);
    Account findAccountById(long id);
}
