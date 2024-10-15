package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Product;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
<<<<<<< HEAD
import com.example.FengShuiKoi.model.ProductRequest;
import com.example.FengShuiKoi.model.Response.ProductResponse;
import com.example.FengShuiKoi.model.Response.UserResponse;
import com.example.FengShuiKoi.repos.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
=======
import com.example.FengShuiKoi.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/forgot-password
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
<<<<<<< HEAD

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
=======
    //CREATE
    public Product create(Product product){
        Product newProduct= productRepository.save(product);
        return newProduct;
    }
    //READ
    public List<Product> getAllProducts(){
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
        oldProduct.setP_Description(product.getP_Description());
        oldProduct.setPrice(product.getPrice());
>>>>>>> origin/forgot-password
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
<<<<<<< HEAD

=======
        //if user.status== "BLOCK" => throw new EntityNotFoundException("Student not found!");
>>>>>>> origin/forgot-password

        return oldProduct;
    }
}

