package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.model.UserRequest;
<<<<<<< HEAD
import com.example.FengShuiKoi.model.Response.UserResponse;
=======
import com.example.FengShuiKoi.repos.UserRepository;
>>>>>>> origin/forgot-password
import com.example.FengShuiKoi.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

>>>>>>> origin/forgot-password
@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@SecurityRequirement(name = "api")

<<<<<<< HEAD

=======
>>>>>>> origin/forgot-password
public class UserController {

    @Autowired
    UserService userService;

<<<<<<< HEAD


    @PostMapping

    public ResponseEntity createUser(@Valid @RequestBody UserRequest userRequest) {
        User newUser = userService.createUser(userRequest);
=======
    List<User> users = new ArrayList<>();

    @PostMapping

    public ResponseEntity createUser(@Valid @RequestBody UserRequest user) {
        User newUser = userService.createUser(user);
>>>>>>> origin/forgot-password

        return ResponseEntity.ok(newUser);
    }


    @GetMapping
<<<<<<< HEAD
    public ResponseEntity  getAllUsers(
            @RequestParam int page,
            @RequestParam(defaultValue = "5") int size) {
        UserResponse userResponse = userService.getAllUser(page, size);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable long userId, @Valid @RequestBody UserRequest userRequest) {
        User updatedUser = userService.update(userId, userRequest);
=======
    public ResponseEntity getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable long userId, @Valid @RequestBody User user) {
        User updatedUser = userService.update(userId, user);
>>>>>>> origin/forgot-password
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
}

}


