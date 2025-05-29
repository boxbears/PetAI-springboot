package com.petaiprogram.mapper;

import com.petaiprogram.domain.goods.AddressItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("select *from address where userId = #{userId}")
    List<AddressItem> findAll(int userId);

    @Insert("INSERT INTO address (receiver, contact, fullLocation, provinceCode, cityCode, countyCode, address, isDefault,userId)" +
            "VALUES (#{receiver}, #{contact}, #{fullLocation}, #{provinceCode}, #{cityCode}, #{countyCode}, #{address}, #{isDefault},#{userId})")
    void add(AddressItem addressItem);

//    @Select("SELECT receiver, contact, address FROM address WHERE id = (SELECT addressId FROM `orders` WHERE orderId = #{orderId})")
//    AddressItem findById(@Param("orderId") String orderId, @Param("userId") int userId);

}
