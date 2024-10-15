package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product){
        Product newProduct= productService.create(product);

        return ResponseEntity.ok(newProduct);
    }
    //lấy sinh viên hiện tại
    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    //api/student/{studentId}
    @PutMapping("{productId}")
    public ResponseEntity update(@PathVariable long productId, @Valid @RequestBody Product product){
        Product updatedProduct= productService.update(productId,product);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("{productId}")
    public ResponseEntity delete(@PathVariable long productId){
        Product deletedProduct=productService.delete(productId);
        return ResponseEntity.ok(deletedProduct);
    }
    @GetMapping("{productId}")
    public ResponseEntity getProductById(@PathVariable long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }
}

