package com.petaiprogram.service;

import com.petaiprogram.domain.goods.*;

import java.util.List;
import java.util.Map;

public interface OrderService {
//    void add(Order order, int userId,int count, String name,String skuId, String picture, String attrsText,String price);

//    void deleteById(String id, int userId);

    List<OrderResult> findAll(int userId);

    Orders orderGenerated(int userId,boolean now);

    GoodsOrders orderSubmit(RequestOrder requestOrder,int userId);

    PayOrder getOrder(String id);

    List<OrderDetails> orderDetail(Map<Object, Object> map);

    void update(PayOrder payOrder);

    int findState(String id);

    OrderPreResult BuyAgain(String id,int userId);

    void deleteOrder(String orderId, int userId);
}
