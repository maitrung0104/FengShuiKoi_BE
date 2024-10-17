package com.example.FengShuiKoi.repos;
import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Orders, UUID> {
    List<Orders> findOrdersByMember(Account member);
    Orders findOrdersById(UUID id);
}