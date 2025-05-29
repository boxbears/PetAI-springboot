package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.petaiprogram.domain.goods.*;
import com.petaiprogram.mapper.AddressMapper;
import com.petaiprogram.mapper.GoodsMapper;
import com.petaiprogram.mapper.OrderMapper;
import com.petaiprogram.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AddressMapper addressMapper;

//    @Override
//    public void add(Order order, int userId,int count, String name,String skuId, String picture, String attrsText,String price) {
//        orderMapper.add(order,userId,count,name,skuId,picture,attrsText,price);
//    }



//    @Override
//    public void deleteById(String id, int userId) {
//        orderMapper.delteBYid(id,userId);
//    }


    @Override
    public List<OrderResult> findAll(int userId) {
        return orderMapper.findAll(userId);
    }

    @Override
    public Orders orderGenerated(int userId,boolean now) {
        // 查询订单商品集合
        List<GoodsOrder> goods = orderMapper.selectCart(userId,now);
        // 查询订单内用户地址列表
        List<UserAddresses> userAddresses = orderMapper.selectUserAddresses(userId);
        // 生成订单总计信息
        // 计算总价
        BigDecimal totalPrice = BigDecimal.ZERO;
        int count = 0;
        for (GoodsOrder good : goods) {
            BigDecimal price = new BigDecimal(good.getPrice());
            totalPrice = totalPrice.add(price.multiply(BigDecimal.valueOf(good.getCount())));
            count += good.getCount();
        }
        // 设置总计信息
        Summary summary = new Summary();
        summary.setGoodsCount(count);
        summary.setPostFee(5);
        summary.setTotalPrice(totalPrice.intValue());
        summary.setTotalPayPrice(totalPrice.add(BigDecimal.valueOf(5)).intValue());
        // 保存订单总计信息
        orderMapper.insertSummary(summary);
        // 构造订单对象并返回
        Orders orders = new Orders(userAddresses, goods, summary);
        return orders;
    }

    @Override
    public GoodsOrders orderSubmit(RequestOrder requestOrder,int userId) {
        List<SpecValue> goods = requestOrder.getGoods();
        List<String> skuId = goods.stream().map(good -> good.getSkuId()).collect(Collectors.toList());
// 初始化一个空字符串用于存储拼接结果
        String skuList = "";
// 使用for-each循环遍历skuId集合
        for (String skuIdItem : skuId) {
            // 将每个skuIdItem拼接到skuList字符串后面，并使用逗号作为分隔符
            skuList += (skuList.isEmpty() ? "" : ",") + skuIdItem;
        }
        GoodsOrders goodsOrders = new GoodsOrders();
        goodsOrders.setSkuIds(skuList);
        String uuid = String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        goodsOrders.setId(uuid);
        goodsOrders.setPayType(requestOrder.getPayType());
        goodsOrders.setPayChannel(requestOrder.getPayChannel());
        goodsOrders.setPostFee(5);
        int count = 0;
        for(SpecValue goodsOrder : requestOrder.getGoods()){
            count+=goodsOrder.getCount();
        }
        // 检查 totalPrice 是否为空
        String totalPrice = requestOrder.getTotalPrice();
        if (StringUtils.isNotBlank(totalPrice)) {
            goodsOrders.setPayMoney((int) Double.parseDouble(totalPrice));
        } else {
            // 处理 totalPrice 为空的情况，这里我假设设置为 0
            goodsOrders.setPayMoney(0);
        }

// 检查 totalPayPrice 是否为空
        String totalPayPrice = requestOrder.getTotalPrice();
        if (StringUtils.isNotBlank(totalPayPrice)) {
            goodsOrders.setTotalMoney((int) Double.parseDouble(totalPayPrice)+5);
        } else {
            // 处理 totalPayPrice 为空的情况，这里我假设设置为 0
            goodsOrders.setTotalMoney(0);
        }

        goodsOrders.setTotalNum(count);
        LocalDateTime createTime = LocalDateTime.now();
        String time1 = createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:dd"));
        LocalDateTime payLatestTime = createTime.plusMinutes(30);
        String time2 = payLatestTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:dd"));
        goodsOrders.setCreateTime(time1);
        goodsOrders.setPayLatestTime(time2);
        goodsOrders.setOrderState(1);

        StringBuilder skuCountsBuilder = new StringBuilder();
        for (int i = 0; i < goods.size(); i++) {
            SpecValue specValue = goods.get(i);
            skuCountsBuilder.append(specValue.getCount()); // 拼接商品数量
            if (i < goods.size() - 1) {
                skuCountsBuilder.append(", ");
            }
        }

        String skuCounts = skuCountsBuilder.toString();

        goodsOrders.setSkuCounts(skuCounts);
        goodsOrders.setUserId(String.valueOf(userId));
        orderMapper.insertOrders(goodsOrders);


        return goodsOrders;
    }

    @Override
    public PayOrder getOrder(String id) {
        PayOrder payOrder = orderMapper.getOrder(id);
        return payOrder;
    }

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrderDetails> orderDetail(Map<Object, Object> map) {
        List<GoodsOrders> goodsOrders = orderMapper.selectOrders((String) map.get("orderState"));
        if (map.get("orderState").equals("0")) {
            goodsOrders = orderMapper.selectOrdersAll();
        }
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (GoodsOrders goodsOrders1 : goodsOrders) {
            String skuList = orderMapper.findSkuIds(goodsOrders1.getId());
            // 将逗号分隔的字符串分割为数组，并移除空元素
            List<String> skuIds = Arrays.stream(skuList.split(","))
                    .map(String::trim) // 移除元素两端的空白符
                    .filter(s -> !s.isEmpty()) // 过滤掉空元素
                    .collect(Collectors.toList());

                List<Sku1> sku1s = new ArrayList<>();
                for (String skuId : skuIds) {
                    Sku sku = orderMapper.selectSku(skuId);
//                    List<SkuSpec> specValue = orderMapper.selectSkuSpec(skuId);
//                    String attrsText = specValue.get(0).getName() + " " + specValue.get(0).getValueName()
//                            + " " + specValue.get(1).getName() + " " + specValue.get(1).getValueName();
                    GoodDetails goodDetails = goodsMapper.goodById(sku.getGoodId());
                    Sku1 sku1 = new Sku1(skuId, sku.getPicture(), goodDetails.getName(), null, sku.getPrice(), goodsOrders1.getTotalNum());
                    sku1s.add(sku1);
                }
                OrderDetails orderDetails1 = new OrderDetails(goodsOrders1.getId(), goodsOrders1.getCreateTime(), goodsOrders1.getOrderState(), sku1s, goodsOrders1.getPostFee(), goodsOrders1.getPayMoney(), goodsOrders1.getTotalMoney());
                orderDetails.add(orderDetails1);
        }
        return orderDetails;
    }


    @Override
    public void update(PayOrder payOrder) {
        orderMapper.update(payOrder);
    }

    @Override
    public int findState(String id) {
        int state = orderMapper.findOrderState(id);
        return state;
    }



    //根据订单id获取商品信息
    @Override
    public OrderPreResult BuyAgain(String id,int userId) {
        String skuList = orderMapper.findSkuIds(id);
        // 将逗号分隔的字符串分割为数组，并移除空元素
        List<String> skuIds = Arrays.stream(skuList.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        String countList = orderMapper.findCounts(id);

        List<String> counts = Arrays.stream(countList.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        OrderPreResult orderPreResult = new OrderPreResult();

        //查询用户地址合集
        List<AddressItem> addressItems = addressMapper.findAll(userId);
        orderPreResult.setUserAddresses(addressItems);

        //订单支付
        Summary summary = orderMapper.findOrderById(id);
        orderPreResult.setSummary(summary);

        //sku合集

        List<Sku1> skus = new ArrayList<>();
        int i = 0;
        for (String skuId : skuIds) {
            Sku sku = orderMapper.selectSku(skuId);
            List<String> valueName = orderMapper.findAttrsTextName(sku.getId());
            String joinedString = String.join(", ", valueName);
            GoodDetails goodDetails = goodsMapper.goodById(sku.getGoodId());
            int count = Integer.parseInt(counts.get(i));
            Sku1 sku1 = new Sku1(skuId, sku.getPicture(), goodDetails.getName(), joinedString, sku.getPrice(),count);
            skus.add(sku1);
            i++;
        }
        orderPreResult.setGoods(skus);
        return orderPreResult;
    }

    @Override
    public void deleteOrder(String orderId, int userId) {
        orderMapper.delteBYid(orderId,userId);
    }


}
