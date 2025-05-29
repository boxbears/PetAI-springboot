package com.petaiprogram.service.impl;

import com.petaiprogram.domain.goods.ProductDetail;
import com.petaiprogram.mapper.ProductDetailMapper;
import com.petaiprogram.service.ProdcutDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProdcutDetailService {
    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Override
    public ProductDetail getGoodsById(String id) {
        ProductDetail productDetail = productDetailMapper.getGoodsById(id);
        return productDetail;
    }

    @Override
    public String findPicData(String id) {
        String picData = productDetailMapper.findPicData(id);
        return picData;
    }

    @Override
    public String findDetail(String id) {
        String DetailData = productDetailMapper.findDetail(id);
        return DetailData;
    }

    @Override
    public String findSimData(String id) {
        String SimData = productDetailMapper.findSimData(id);
        return SimData;
    }

    @Override
    public String findSku(String id) {
        String skuData = productDetailMapper.findSku(id);
        return skuData;
    }

    @Override
    public String findSpece(String id) {
        String SpeceData = productDetailMapper.findSpece(id);
        return SpeceData;
    }

    @Override
    public List<String> findAll() {
        return (List<String>) productDetailMapper.findAll();
    }
}
