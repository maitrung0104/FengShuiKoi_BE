package com.example.FengShuiKoi.api;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin("*") //
@RequestMapping("/api/koi")
public class KoiAPI {

    @Autowired
    ProductService productService;
    @PostMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity create(@Valid @RequestBody Product product){
        Product newStudent= productService.create(product);

        return ResponseEntity.ok(newStudent);
    }
    //lấy sinh viên hiện tại
    @GetMapping
    public ResponseEntity getAllStudent() {
        List<Product> students=productService.getAllStudent();
        return ResponseEntity.ok(students);
    }
    //api/student/{studentId}
    @PutMapping("{studentId}")
    public ResponseEntity update(@PathVariable long studentId,@Valid @RequestBody Product product){
        Product updatedProduct= productService.update(studentId,product);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("{ProductId}")
    public ResponseEntity delete(@PathVariable long studentId){
        Product deletedProduct=productService.delete(studentId);
        return ResponseEntity.ok(deletedProduct);
    }
}
