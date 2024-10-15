package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.model.UserRequest;
import com.example.FengShuiKoi.model.Response.UserResponse;
import com.example.FengShuiKoi.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity  getAllUsers(
            @RequestParam int page,
            @RequestParam(defaultValue = "5") int size) {
        UserResponse userResponse = userService.getAllUser(page, size);
        return ResponseEntity.ok(userResponse);
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


