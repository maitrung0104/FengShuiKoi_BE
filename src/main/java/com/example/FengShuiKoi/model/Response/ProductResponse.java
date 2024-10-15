package com.example.FengShuiKoi.model.Response;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {

    List<Product> content;
    int pageNumber;
    int totalElements;
    int totalPages;

}
