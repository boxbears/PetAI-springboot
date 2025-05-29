package com.petaiprogram.mapper;

import com.petaiprogram.domain.goods.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Insert("INSERT INTO cart (id, skuId, name, picture, count, price, selected, attrsText, user_id,is_Now) " +
            "VALUES (#{id}, #{skuId}, #{name}, #{picture}, #{count}, #{price}, #{selected}, #{attrsText}, #{userId},#{now})")
    void add(Cart cart);

    @Select("select *from cart where skuId=#{skuId} and is_Now = #{now}")
    Cart findSkuID(String skuId,boolean now);

    @Update("update cart set count = #{count} where skuId=#{skuId} and user_id=#{userId}")
    void addCount(int count,String skuId,int userId);

    @Select("select *from cart where user_id=#{userId} and is_Now = false")
    List<Cart> findAll(int userId);

    @Delete("delete from cart where skuId=#{skuId} and user_id=#{userId}")
    void delete(String skuId,int userId);

    @Update("update cart set selected=#{selected} where skuId=#{skuId} and user_id=#{userId}")
    void updateSelected(Boolean selected,String skuId,int userId);

    @Update("update cart set selected=#{selected} where user_id=#{userId}")
    void updateAllSelected(Boolean selected,int userId);

    @Delete("delete from cart where user_id = #{userId} and is_Now = #{now}")
    void deleteCart(int userId,boolean now);
}
