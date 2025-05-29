package com.petaiprogram.service;

import com.petaiprogram.domain.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.petaiprogram.domain.goods.GoodDetails;

/**
* @author 27609
* @description 针对表【goods】的数据库操作Service
* @createDate 2024-02-02 15:50:22
*/
public interface GoodsService{

    GoodDetails goodById(Integer integer);
}
