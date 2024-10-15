package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {



     List<User> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.get(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        users.set(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        users.remove(id);
    }
}