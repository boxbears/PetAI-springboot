package com.petaiprogram.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petaiprogram.domain.goods.Cart;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.CartService;
import com.petaiprogram.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/miniTest")
public class CartController {
    @Autowired
    private CartService cartService;

    private int getUserId(String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        int useId = (int) map.get("id");
        return useId;
    }

    //加入购物车
    @PostMapping("/member/cart")
    public ResponseResult addCart(@RequestBody Map<String, Object> requestBody , @RequestHeader("Authorization") String token){
        String skuId = (String) requestBody.get("skuId");
        int count = Integer.parseInt((String) requestBody.get("count").toString());
        String name = (String) requestBody.get("name");
        String image = (String) requestBody.get("image");
        double price = Double.parseDouble((String) requestBody.get("price").toString());
        List<String> skuArrList = (List<String>) requestBody.get("skuArr");
        String[] skuArr = skuArrList.toArray(new String[0]);
        String skuArrString = String.join(",", skuArr);
        Boolean skuTure = true;
        String id = (String) requestBody.get("id");//商品id
        boolean now = false;

        int useId = getUserId(token);

        Cart cart1 = cartService.find(skuId,now);
        if(cart1==null){
            Cart cart = new Cart();
            cart.setName(name);
            cart.setPrice((int) price/100);
            cart.setCount(count);
            cart.setPicture(image);
            cart.setSkuId(skuId);
            cart.setAttrsText(skuArrString);
            cart.setSelected(skuTure);
            cart.setId(id);
            cart.setUserId(String.valueOf(useId));
            cart.setNow(now);
            cartService.add(cart);
        }else {
            count = cart1.getCount()+count;
            cartService.updateCount(count,skuId,useId);
        }

        return ResponseResult.ok();
    }

    //获取购物车信息
    @GetMapping("/get/cart")
    public ResponseResult getCart(@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        List<Cart> cartList = cartService.findAll(userId);
        return ResponseResult.ok(cartList);
    }

    //删除购物车
    @DeleteMapping("/delete/cart")
    public ResponseResult deleteCart(@RequestBody Map<String, Object> requestBody,@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        String skuId = (String) requestBody.get("ids");
        cartService.delete(skuId,userId);
        return ResponseResult.ok();
    }
    //购物车添加商品数量
    @PutMapping("/cart/count/{skuId}")
    public ResponseResult updateCartCount(@PathVariable String skuId, @RequestBody Map<String, Object> requestData,@RequestHeader("Authorization") String token) {
        Integer count = (int) requestData.get("count");
        Boolean selected = (Boolean) requestData.get("selected");
        int userId = getUserId(token);

        if(count!=null){
            cartService.updateCount(count,skuId,userId);
        }
        if(selected!=null){
            cartService.updateSelected(selected,skuId,userId);
        }
        return ResponseResult.ok();
    }

    //购物车选中或取消选中商品选中状态
    @PutMapping("/cart/selected/{skuId}")
    public ResponseResult updateSelected(@PathVariable String skuId, @RequestBody Map<String, Object> requestData,@RequestHeader("Authorization") String token) {
        Boolean selected = (Boolean) requestData.get("selected");
        int userId = getUserId(token);
        if (selected != null) {
            cartService.updateSelected(selected, skuId,userId);
        }
        return ResponseResult.ok();
    }


    //商品全选状态
    @PutMapping("/member/cart/selected")
    public ResponseResult updateAllSelected(@RequestBody Map<String, Object> requestData,@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        Boolean selected = (Boolean) requestData.get("selected");
        if(selected!=null){
            cartService.updateAllSelected(selected,userId);
        }
        return ResponseResult.ok();
    }


}
