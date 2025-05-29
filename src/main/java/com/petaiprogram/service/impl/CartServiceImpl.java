package com.petaiprogram.service.impl;

import com.petaiprogram.domain.goods.Cart;
import com.petaiprogram.mapper.CartMapper;
import com.petaiprogram.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Override
    public void add(Cart cart) {
        cartMapper.add(cart);
    }

    @Override
    public Cart find(String skuId,boolean now) {
        Cart cart = cartMapper.findSkuID(skuId,now);
        return cart;
    }

    @Override
    public void updateCount(int count,String skuId,int userId) {
        cartMapper.addCount(count,skuId,userId);
    }

    @Override
    public List<Cart> findAll(int userId) {
        List<Cart> cartList = cartMapper.findAll(userId);
        return cartList;
    }

    @Override
    public void delete(String skuId,int userId) {
        cartMapper.delete(skuId,userId);
    }

    @Override
    public void updateSelected(Boolean selected,String skuId,int userId) {
        cartMapper.updateSelected(selected,skuId,userId);
    }

    @Override
    public void updateAllSelected(Boolean selected,int userId) {
        cartMapper.updateAllSelected(selected,userId);
    }

    @Override
    public void deleteCart(int userId,boolean now) {
        cartMapper.deleteCart(userId,now);
    }
}
