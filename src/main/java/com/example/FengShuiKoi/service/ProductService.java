package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.exception.DuplicateEntity;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    ProductRepository productRepository;
    //CREATE
    public Product create(ProductRequest productRequest) {
        try {
            Product product = modelMapper.map(productRequest, Product.class);
            Account accountRequest = authenticationService.getCurrentAccount();
            product.setAccount(accountRequest); //set thong tin student cua account nay

            Product newProduct = productRepository.save(product);
            return newProduct;
        }catch (Exception e) {
            throw new DuplicateEntity("Duplication product code");

        }
    }
    //READ
    public List<Product> getAllProduct(){
        List<Product>products=productRepository.findProductsByIsDeletedFalse()   ;
        return products;
    }
    //UPDATE
    public Product update(long id,Product product){
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

        return oldProduct;
    }
}
