package com.petaiprogram.controller;

import com.petaiprogram.domain.goods.*;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.AddressService;
import com.petaiprogram.service.CartService;
import com.petaiprogram.service.OrderService;
import com.petaiprogram.utils.JwtUtil;
import com.petaiprogram.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/miniTest")
public class OrderController {
    private int getUserId(String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        int useId = (int) map.get("id");
        return useId;
    }

    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;

    //生成订单
    @GetMapping("/member/order/pre")
    public ResponseResult orderGenerated(@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        //1.生成订单
        boolean now = false;
        Orders orders = orderService.orderGenerated(userId,now);
        return ResponseResult.ok(orders);
    }

    //生成立即支付的订单
    @GetMapping("/member/buy/now")
    public ResponseResult orderBuyNow(@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        //1.生成订单
        boolean now = true;
        Orders orders = orderService.orderGenerated(userId,now);
        cartService.deleteCart(userId,now);
        return ResponseResult.ok(orders);
    }

    //保存地址
    @PostMapping("/member/address")
    public ResponseResult SaveAddress(@RequestBody Map<String, Object> requestData, @RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        AddressItem addressItem = new AddressItem();
        String receiver = (String) requestData.get("receiver");
        addressItem.setReceiver(receiver);
        String contact = (String) requestData.get("contact");
        addressItem.setContact(contact);
        String fullLocation = (String) requestData.get("fullLocation");
        addressItem.setFullLocation(fullLocation);
        String provinceCode = (String) requestData.get("provinceCode");
        addressItem.setProvinceCode(provinceCode);
        String cityCode = (String) requestData.get("cityCode");
        addressItem.setCityCode(cityCode);
        String countyCode = (String) requestData.get("countyCode");
        addressItem.setCountyCode(countyCode);
        String address = (String) requestData.get("address");
        addressItem.setAddress(address);
        Integer isDefault = (Integer) requestData.get("isDefault");
        addressItem.setIsDefault(isDefault);
        addressItem.setUserId(userId);
        addressService.add(addressItem);
        return ResponseResult.ok(addressItem);
    }

    //获取地址信息
    @GetMapping("/member/get/address")
    public ResponseResult GetAddress(@RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        List<AddressItem> addressItems = addressService.findAll(userId);
        return ResponseResult.ok(addressItems);
    }

    //获取商品信息（立即支付）
    @PostMapping("/member/order/pre/now")
    public ResponseResult BuyNow(@RequestBody Map<String, Object> requestBody , @RequestHeader("Authorization") String token){
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
        boolean now = true;

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

    @Autowired
    private OrderService orderService;

    @PostMapping("/member/order")
    public ResponseResult orderSubmit(@RequestBody RequestOrder requestOrder,@RequestHeader("Authorization") String token){
        int userId = getUserId(token);

        GoodsOrders goodsOrders = orderService.orderSubmit(requestOrder,userId);

//        cartService.deleteCart(userId);
        return ResponseResult.ok(goodsOrders.getId());
    }


    @GetMapping("/get/order/{id}")
    public ResponseResult getOrder(@PathVariable String id, @RequestHeader("Authorization") String token){
        PayOrder payOrder = orderService.getOrder(id);
        payOrder.setCountdown(30*60);
        int orderState = orderService.findState(id);
        payOrder.setOrderState(orderState);
        return ResponseResult.ok(payOrder);
    }

    //根据订单获取订单信息
    @GetMapping("/order/again/{id}")
    public ResponseResult OrderAgain(@PathVariable String id, @RequestHeader("Authorization") String token){
        System.out.println(id);
        int userId = getUserId(token);
        OrderPreResult orders = orderService.BuyAgain(id,userId);
        return ResponseResult.ok(orders);
    }

    //模拟支付
    @GetMapping("/pay/mock")
    public ResponseResult pay(@RequestParam("orderId") String orderId, @RequestHeader("Authorization") String token) {
        PayOrder payOrder = orderService.getOrder(orderId);
        payOrder.setOrderState(2);
        orderService.update(payOrder);
        return ResponseResult.ok(true);
    }


    //模拟发货
    @GetMapping("/order/consignment")
    public ResponseResult consignment(@RequestParam("orderId") String orderId, @RequestHeader("Authorization") String token) {
        int userId = getUserId(token);
        PayOrder payOrder = orderService.getOrder(orderId);
        payOrder.setOrderState(3);
        orderService.update(payOrder);
        return ResponseResult.ok();
    }

    //确认收货
    @PutMapping("/member/order/{id}/receipt")
    public ResponseResult receipt(@PathVariable String id, @RequestHeader("Authorization") String token){
        int userId = getUserId(token);
        PayOrder payOrder = orderService.getOrder(id);
        payOrder.setOrderState(4);
        orderService.update(payOrder);
        return ResponseResult.ok();
    }


    //订单列表
    @GetMapping("/order")
    public ResponseResult orderDetails(@RequestParam Map<Object,Object> map){
        List<OrderDetails> orderDetails = orderService.orderDetail(map);
        return ResponseResult.ok(orderDetails);
    }

    //取消订单
    @GetMapping("/cancel/order/{orderId}")
    public ResponseResult CancelOrder(@PathVariable String orderId,@RequestHeader("Authorization") String token){
        int userId  = getUserId(token);
        orderService.deleteOrder(orderId,userId);
        return ResponseResult.ok();
    }
}
