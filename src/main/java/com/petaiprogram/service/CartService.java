package com.petaiprogram.service;

import com.petaiprogram.domain.goods.Cart;

import java.util.List;

public interface CartService {
    void add(Cart cart);

    Cart find(String skuId,boolean now);

    void updateCount(int count,String skuId,int userId);

    List<Cart> findAll(int userId);

    void delete(String skuId,int userId);

    void updateSelected(Boolean selected,String skuId,int userId);

    void updateAllSelected(Boolean selected,int userId);

    void deleteCart(int userId,boolean now);
}
