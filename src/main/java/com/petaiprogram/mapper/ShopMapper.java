package com.petaiprogram.mapper;

import com.petaiprogram.domain.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【shop】的数据库操作Mapper
* @createDate 2023-11-26 15:14:05
* @Entity com.petaiprogram.domain.Shop
*/
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

}




