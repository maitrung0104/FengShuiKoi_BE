package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.model.UserRequest;
import com.example.FengShuiKoi.repos.UserRepository;
import com.example.FengShuiKoi.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@SecurityRequirement(name = "api")


public class UserController {

    @Autowired
    UserService userService;



    @PostMapping

    public ResponseEntity createUser(@Valid @RequestBody UserRequest userRequest) {
        User newUser = userService.createUser(userRequest);

        return ResponseEntity.ok(newUser);
    }



    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable long userId, @Valid @RequestBody UserRequest userRequest) {
        User updatedUser = userService.update(userId, userRequest);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
}

}


