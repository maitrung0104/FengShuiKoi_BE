package com.example.FengShuiKoi.api;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
@SecurityRequirement(name="api")
public class ProductAPI {
    @Autowired
    ProductService productService;
    @PostMapping
    @PreAuthorize("hasAuthority('MEMBER')")

    public ResponseEntity create(@Valid @RequestBody ProductRequest product ){
        Product newProduct= productService.create(product);

        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity getAllStudent() {
        List<Product> products=productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
    //api/student/{studentId}
    @PutMapping("{productID}")
    public ResponseEntity update(@PathVariable long productId,@Valid @RequestBody Product product){
        Product updateProduct= productService.update(productId,product);
        return ResponseEntity.ok(updateProduct);
    }
    @DeleteMapping("{productId}")
    public ResponseEntity delete(@PathVariable long productId){
        Product deletedProduct=productService.delete(productId);
        return ResponseEntity.ok(deletedProduct);
    }
}
