package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
