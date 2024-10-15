package com.example.FengShuiKoi.service;


import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    //CRUD
    //create
    public User createUser(User user){
        User newUser = userRepository.save(user);
            return newUser;
    }
    //Read
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    //Update
    public User update(long id, User user){
       User oldUser = userRepository.findUserById(id);

       if( oldUser == null) throw new EntityNotFoundException("User not found");

       oldUser.setName(user.getName());
       oldUser.setAge(user.getAge());
       oldUser.setGender(user.getGender());
       oldUser.setEmail(user.getEmail());
       oldUser.setAddress(user.getAddress());
       oldUser.setPhone(user.getPhone());
       oldUser.setDateOfBirth(user.getDateOfBirth());

       //save
        return userRepository.save(oldUser);

    }
    // Delete
    public void deleteUser(long id) {
        User user = userRepository.findUserById(id);
        if (user == null) throw new EntityNotFoundException("User not found");
        userRepository.delete(user);
    }

}
