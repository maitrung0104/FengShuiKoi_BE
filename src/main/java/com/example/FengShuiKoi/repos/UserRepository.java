package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    
}
