package com.example.FengShuiKoi.service;


import com.example.FengShuiKoi.entity.User;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.model.UserRequest;
import com.example.FengShuiKoi.model.Response.UserResponse;
import com.example.FengShuiKoi.repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public UserResponse getAllUser(int page, int size){

         Page users = userRepository.findAll(PageRequest.of(page, size));
         UserResponse userResponse = new UserResponse();
            userResponse.setContent(users.getContent());
            userResponse.setPageNumber(users.getNumber());
            userResponse.setTotalElements(users.getNumberOfElements());
            userResponse.setTotalPages(users.getTotalPages());


             return userResponse;
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




