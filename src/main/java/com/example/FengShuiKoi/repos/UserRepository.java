<<<<<<< HEAD
// src/main/java/com/example/FengShuiKoi/repos/UserRepository.java
package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    Page<User> findAll(Pageable pageable);
}
=======
package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
>>>>>>> origin/forgot-password
