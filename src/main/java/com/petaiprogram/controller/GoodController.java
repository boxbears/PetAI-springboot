package com.petaiprogram.controller;

import com.petaiprogram.domain.goods.GoodDetails;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniTest")
public class GoodController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 商品详情
     */
    @GetMapping("/goods")
    public ResponseResult goodById(String id){
        //查询商品全部信息
        GoodDetails goodDetails = goodsService.goodById(Integer.valueOf(id));
        return ResponseResult.ok(goodDetails);
    }
}
