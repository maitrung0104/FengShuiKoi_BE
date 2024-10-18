package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsername(String username);

    Account findAccountById(long id);

    Account findAccountByEmail(String email);

    Account findAccountByRole(Role role);

}


