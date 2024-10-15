package com.example.FengShuiKoi.service;


import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.model.UserRequest;
import com.example.FengShuiKoi.model.UserResponse;
import com.example.FengShuiKoi.repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;








    //CRUD
    //create
    public User createUser(UserRequest userRequest){
        //add user vao db bang repos
        try {

            User user = modelMapper.map(userRequest, User.class);
            User newUser = userRepository.save(user);
            return newUser;
        }catch (Exception e){
            throw new DuplicateEntity("Duplicate email");
        }
    }
    //Read
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    //Update

    public User update(long id, UserRequest userRequest){
        User oldUser = userRepository.findUserById(id);

        if( oldUser == null) throw new EntityNotFoundException("User not found");

        modelMapper.map(userRequest, oldUser);

        oldUser.setName(userRequest.getName());
        oldUser.setAge(userRequest.getAge());
        oldUser.setGender(userRequest.getGender());
        oldUser.setEmail(userRequest.getEmail());
        oldUser.setAddress(userRequest.getAddress());
        oldUser.setPhone(userRequest.getPhone());
        oldUser.setDateOfBirth(userRequest.getDateOfBirth());

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




