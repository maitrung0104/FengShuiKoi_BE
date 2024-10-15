package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.model.Response.ProductResponse;
import com.example.FengShuiKoi.model.Response.UserResponse;
import com.example.FengShuiKoi.repos.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;
    //CREATE
   public Product createProduct(ProductRequest productRequest)  {
         try {
              Product product = modelMapper.map(productRequest, Product.class);
              Product newProduct = productRepository.save(product);
              return newProduct;
         }catch (Exception e){
              throw new EntityNotFoundException("Duplicate product code");
         }
   }
    //READ
    public ProductResponse getAllProducts(int page, int size) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productResponse.getContent());
        productResponse.setPageNumber(productResponse.getPageNumber());
        productResponse.setTotalElements(productResponse.getTotalElements());
        productResponse.setTotalPages(productResponse.getTotalPages());
        return productResponse;
    }
    //UPDATE
    public Product update(long id,ProductRequest productRequest){
        //Buoc 1 Tìm ra thằng product càn được update thông qua id
        Product oldProduct= productRepository.findProductById(id);

        if(oldProduct== null) throw new EntityNotFoundException("Product not Found!");

        modelMapper.map(productRequest, oldProduct);
        //=> cos ton tai
        // Buoc 2 cập nhật thông tin
        oldProduct.setProductCode(productRequest.getProductCode());
        oldProduct.setSpecies(productRequest.getSpecies());
        oldProduct.setAge(productRequest.getAge());
        oldProduct.setColour(productRequest.getColour());
        oldProduct.setSize(productRequest.getSize());
        oldProduct.setOrigin(productRequest.getOrigin());
        oldProduct.setP_element(productRequest.getP_element());
        oldProduct.setDescription(productRequest.getDescription());
        oldProduct.setPrice(productRequest.getPrice());
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

