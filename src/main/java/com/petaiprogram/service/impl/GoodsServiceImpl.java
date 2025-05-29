package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Goods;
import com.petaiprogram.domain.goods.*;
import com.petaiprogram.service.GoodsService;
import com.petaiprogram.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 27609
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2024-02-02 15:50:22
*/
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public GoodDetails goodById(Integer id) {
        //1.查询商品信息
        GoodDetails goodDetails = goodsMapper.goodById(id);
        //2.查询商品品牌
        Brand brand = goodsMapper.selectBrand(goodDetails.getBrandId());
        if(brand!=null){
            goodDetails.setBrand(brand);
        }
        //4.查询商品主图集合
        List<String> pictures = goodsMapper.selectPicture(id);
        if(pictures!=null&&!pictures.isEmpty()){
            goodDetails.setMainPictures(pictures);
        }
        //5.查询商品可选规格集合备注：规格集合一定要和skus集合下的specs 顺序保持一致
        List<Spec> specs = goodsMapper.selectSpec(id);
        specs.stream().forEach(spec -> {
            List<SpecValue> specValues = goodsMapper.selectSpecValue(spec.getId());
            spec.setValues(specValues);
        });
        if(specs!=null&&!specs.isEmpty()){
            goodDetails.setSpecs(specs);
        }
        //6.查询商品sku集合
        List<Sku> skus = goodsMapper.selectSku(id);
        skus.stream().forEach(sku -> {
            List<Spec2> spec2s = goodsMapper.selectSpecValues(Integer.valueOf(sku.getId()));
            sku.setSpecs(spec2s);
        });
        if(skus!=null&&!skus.isEmpty()){
            goodDetails.setSkus(skus);
        }
        //8.查询商品详情
        List<String> pictures1 = goodsMapper.selectDetails(id);
        List<Property> properties = goodsMapper.selectProperty(id);
        Details details = new Details();
        if(pictures1==null){
            goodDetails.setDetails(details);
        }else{
            details.setPictures(pictures1);
            details.setProperties(properties);
            goodDetails.setDetails(details);
        }
//        List<SimilarProducts> similarProducts = goodsMapper.selectProducts(id,Integer.valueOf(goodDetails.getTypeId()));
//        if(similarProducts!=null&&!similarProducts.isEmpty()){
//            goodDetails.setSimilarProducts(similarProducts);
//        }
        return goodDetails;
    }
}




