//package com.example.FengShuiKoi.service;
//
//
//import com.example.FengShuiKoi.entity.Cart;
//import com.example.FengShuiKoi.entity.CartItem;
//import com.example.FengShuiKoi.entity.Product;
//import com.example.FengShuiKoi.repos.CartItemRepository;
//import com.example.FengShuiKoi.repos.CartRepository;
//import com.example.FengShuiKoi.repos.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartService {
//
//    @Autowired
//    CartRepository cartRepository;
//
//    @Autowired
//    CartItemRepository cartItemRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    public Cart addToCart(Long cartId, Long productId, int quantity) {
//        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
//        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
//
//        CartItem cartItem = new CartItem();
//        cartItem.setCart(cart);
//        cartItem.setProduct(product);
//        cartItem.setQuantity(quantity);
//
//        cart.getItems().add(cartItem);
//        cartItemRepository.save(cartItem);
//        return cartRepository.save(cart);
//    }
//}