package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> { // cung cấp entity và kiểu dữ liệu của PK
    // vì jpa đã giúp xử lí phần logic -> cho class này là interface nên ko cần code gì cả
    Account findAccountByPhone(String phone);

    Account findAccountById(Long id);

    Account findAccountByEmail(String email);
}
