package com.petaiprogram.mapper;

import com.petaiprogram.domain.goods.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductDetailMapper {
    @Select("select *from productdetail where id=#{id}")
    ProductDetail getGoodsById(String id);

    @Select("select mainPictures from productdetail where id=#{id}")
    String findPicData(String id);

    @Select("select details from productdetail where id=#{id}")
    String findDetail(String id);

    @Select("select similarProducts from productdetail where id=#{id}")
    String findSimData(String id);

    @Select("select skus from productdetail where id=#{id}")
    String findSku(String id);

    @Select("select specs from productdetail where id=#{id}")
    String findSpece(String id);

    @Select("select skus from productdetail")
    List<String> findAll();
}
