package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.repos.UserRepository;
import com.example.FengShuiKoi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    List<User> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User newUser = userService.createUser(user);

        return ResponseEntity.ok(newUser);
    }


    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable long userId, @Valid @RequestBody User user) {
        User updatedUser = userService.update(userId, user);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
}

}


