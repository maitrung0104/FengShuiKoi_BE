package com.example.FengShuiKoi.repository;

import com.example.FengShuiKoi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //findProductById(long id)
    Product findProductById(long id);
    List<Product> findProductsByIsDeletedFalse();

}
