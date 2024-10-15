package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
