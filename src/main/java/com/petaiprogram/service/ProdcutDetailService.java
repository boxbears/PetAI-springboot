package com.petaiprogram.service;

import com.petaiprogram.domain.goods.ProductDetail;

import java.util.List;

public interface ProdcutDetailService {
    ProductDetail getGoodsById(String id);

    String findPicData(String id);

    String findDetail(String id);

    String findSimData(String id);

    String findSku(String id);

    String findSpece(String id);

    List<String> findAll();
}
