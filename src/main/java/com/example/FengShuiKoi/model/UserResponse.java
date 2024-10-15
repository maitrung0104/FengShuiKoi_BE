package com.example.FengShuiKoi.model;

import com.example.FengShuiKoi.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

         List<User> content;
         int pageNumber;
         int totalElements;
         int totalPages;

    }

