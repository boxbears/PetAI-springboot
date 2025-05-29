package com.petaiprogram.mapper;


import com.petaiprogram.domain.Goods;
import com.petaiprogram.domain.goods.*;
import com.petaiprogram.domain.goods.Property;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface GoodsMapper {

    //查询商品的详细信息
    @Select("select * from goods where id = #{id}")
    GoodDetails goodById(Integer id);

    //查询商品品牌id
    @Select("select * from brands where id = #{brandId}")
    Brand selectBrand(Integer brandId);

    //4.查询商品主图集合
    @Select("select pictures from mainpictures where good_id = #{id}")
    List<String> selectPicture(Integer id);

    //查询商品可选规格集合备注：规格集合一定要和skus集合下的specs 顺序保持一致
    @Select("select * from specs where good_id = #{id}")
    List<Spec> selectSpec(Integer id);

    //查询规格可选值集合
    @Select("select * from specs_values where specs_id = #{id}")
    List<SpecValue> selectSpecValue(String id);

    //查询商品sku集合
    @Select("select * from skus where good_id = #{id}")
    List<Sku> selectSku(Integer id);

    //查询具体商品的规格
    @Select("select * from sku_specs where sku_id = #{id}")
    List<Spec2> selectSpecValues(Integer id);


    //查询商品详情
    @Select("select * from details where good_id = #{id}")
    List<String> selectDetails(Integer id);

    @Select("select * from details_properties where good_id = #{id}")
    List<Property> selectProperty(Integer id);


//    //查询商品同类商品集合
//    @Select("select id, picture, discount, orderNum, name, price, `desc` from goods where type_id = #{id2} and id != #{id1}")
//    List<SimilarProducts> selectProducts(Integer id1, Integer id2);
//
//
//
//    @Select("SELECT * FROM goods WHERE name LIKE CONCAT('%', #{search}, '%') LIMIT #{startIndex}, #{pageSize}")
//    List<Goods> findBySearchWithPagination(@Param("search") String search, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
//
//    @Select("select * from goods limit #{page},#{pageSize}")
//    List<GoodDetails> goodAll(Integer page, Integer pageSize);


    @Select("select count(*) from goods")
    Integer count();

//    @Select("SELECT COUNT(*) FROM goods WHERE name LIKE CONCAT('%', #{search}, '%')")
//    int findTotal(@Param("search") String search);


    @Delete("delete from goods where id = #{id}")
    void deleteById(Integer id);

//    @Insert("INSERT INTO goods (name, picture, price, type_id) VALUES (#{name},#{picture},#{price},#{type})")
//    void addGood(String name, String picture, String price, String type);
//
//    @Update("update goods set picture = #{picture},name = #{name},price = #{price},type_id=#{type} where id = #{id} ")
//    void updateGood(String id, String name, String picture, String price, String type);

}
