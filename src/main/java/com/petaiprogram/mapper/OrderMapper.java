package com.petaiprogram.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.petaiprogram.domain.goods.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
//    @Insert("insert into orders(orderId,addressId,deliveryTimeType,buyerMessage,payChannel,payType,orderState,userId,count,name,skuId,picture,attrsText,price)" +
//            " VALUES (#{order.orderId}, #{order.addressId}, #{order.deliveryTimeType}, #{order.buyerMessage}, #{order.payChannel}, #{order.payType},#{order.orderState}, #{userId},#{count},#{name},#{skuId},#{picture},#{attrsText},#{price})")
//    void add(@Param("order") Order order, @Param("userId") int userId ,int count, String name,String skuId, String picture, String attrsText,String price);



    @Delete("delete from orders where id=#{id} and userId=#{userId}")
    void delteBYid(String id, int userId);


    @Select("select *from orders where userId=#{userId}")
    List<OrderResult> findAll(int userId);

    //查询订单商品集合
    @Select("select id, name, picture, price, count, skuId, attrsText, selected, payPrice, totalPrice, totalPayPrice from cart where selected = 1 and user_id = #{userId} and is_Now = #{now}")
    List<GoodsOrder> selectCart(int userId,boolean now);

    //查询订单内用户地址列表
    @Select("select * from address where userId = #{userId}")
    List<UserAddresses> selectUserAddresses(int userId);

    //保存订单总计信息
    @Insert("insert into summary(totalPrice, totalPayPrice, postFee, discountPrice) values (#{totalPrice},#{totalPayPrice},#{postFee},#{discountPrice})")
    void insertSummary(Summary summary);

    //生成订单
    void insertOrders(GoodsOrders goodsOrders);

    //查询商品
    List<Sku> selectSkus(List<SpecValue> goods);

    @Select("select *from orders where id = #{id}")
    PayOrder getOrder(String id);

    //查询所有订单
    @Select("select * from orders where orderState = #{orderState}")
    List<GoodsOrders> selectOrders(String orderState);

    @Select("select id, picture,price,good_id from skus where skuCode = #{skuId}")
    Sku selectSku(String skuId);
//    @Select("select * from sku_specs where sku_id = #{skuId}")
//    List<SkuSpec> selectSkuSpec(String skuId);

    @Select("select *from orders")
    List<GoodsOrders> selectOrdersAll();

    @Update("UPDATE orders SET orderState = #{orderState} WHERE id = #{id}")
    void update(PayOrder payOrder);

    @Select("select orderState from orders where id = #{id}")
    int findOrderState(String id);

    @Select("select skuIds from orders where id = #{id}")
    String findSkuIds(String id);


    @Select("select totalNum,payMoney,totalMoney,postFee from orders where id = #{id}")
    @Results({
            @Result(property = "goodsCount", column = "totalNum"),
            @Result(property = "totalPrice", column = "payMoney"),
            @Result(property = "totalPayPrice", column = "totalMoney"),
            @Result(property = "postFee", column = "postFee")
    })
    Summary findOrderById(String id);

    @Select("select valueName from sku_specs where sku_id = #{id}")
    List<String> findAttrsTextName(String id);

    @Select("select SkuCounts from orders where id = #{id}")
    String findCounts(String id);
}
