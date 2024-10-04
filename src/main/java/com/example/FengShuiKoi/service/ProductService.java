package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    //CREATE
    public Product create(Product product){
        Product newProduct= productRepository.save(product);
        return newProduct;
    }
    //READ
    public List<Product> getAllStudent(){
        List<Product>products=productRepository.findProductsByIsDeletedFalse()   ;
        return products;
    }
    //UPDATE
    public Product update(long id,Product product){
        //Buoc 1 Tìm ra thằng student càn được update thông qua id
        Product oldProduct= productRepository.findProductById(id);

        if(oldProduct== null) throw new EntityNotFoundException("Product not Found!");
        //=> cos ton tai
        // Buoc 2 cập nhật thông tin
        oldProduct.setProductCode(product.getProductCode());
        oldProduct.setSpecies(product.getSpecies());
        oldProduct.setAge(product.getAge());
        oldProduct.setColour(product.getColour());
        oldProduct.setSize(product.getSize());
        oldProduct.setOrigin(product.getOrigin());
        oldProduct.setElement(product.getElement());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        // Bước 3 lưu db
        return productRepository.save(oldProduct);
    }
    //DELETE
    public Product delete(long id){
        Product oldProduct=productRepository.findProductById(id);
        if(oldProduct ==null) throw new EntityNotFoundException("Product not found");
        oldProduct.setDeleted(true);
        return productRepository.save(oldProduct);
    }
    public Product getProductById(long id){
        Product oldProduct= productRepository.findProductById(id);
        if(oldProduct==null) throw new EntityNotFoundException("Product not found !");
        //if user.status== "BLOCK" => throw new EntityNotFoundException("Student not found!");

        return oldProduct;
    }
}
