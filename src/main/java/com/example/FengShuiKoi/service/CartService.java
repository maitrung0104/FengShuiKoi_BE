package com.example.FengShuiKoi.service;


import com.example.FengShuiKoi.entity.Cart;
import com.example.FengShuiKoi.entity.CartItem;
import com.example.FengShuiKoi.entity.Koi;

import com.example.FengShuiKoi.repos.CartItemRepository;
import com.example.FengShuiKoi.repos.CartRepository;
import com.example.FengShuiKoi.repos.KoiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    KoiRepository koiRepository;

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(new Cart());
    }

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }


    public Cart addToCart(Long cartId, UUID koiID, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        Koi koi = koiRepository.findKoiById(koiID);

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setKoi(koi);
        cartItem.setCart(cart);

        cart.getItems().add(cartItem);
        cartItemRepository.save(cartItem);
        return cartRepository.save(cart);
    }
    public void delete(Long cartId, UUID koiID) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        CartItem cartItem = cartItemRepository.findCartItemByCartAndKoi(cart, koiRepository.findKoiById(koiID));
        cart.getItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
        cartRepository.save(cart);
    }

    public Cart updateCart(Long cartId, UUID koiID, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        CartItem cartItem = cartItemRepository.findCartItemByCartAndKoi(cart, koiRepository.findKoiById(koiID));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
        return cartRepository.save(cart);
    }
}