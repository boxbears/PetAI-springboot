package com.petaiprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petaiprogram.domain.Shop;
import com.petaiprogram.domain.vo.PageVo;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    //    根据传入的分类id获取商品数据
    @GetMapping("/getProduct")
    public void get_product(@RequestParam Map<Object, Object> map) {
        System.out.println(map.get("id") + "+" + map.get("page"));

    }

    /**
     * 获取分页商品数据
     *
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/Product/{id}")
    public PageVo Test(@PathVariable("id") int id, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        QueryWrapper<Shop> qw = new QueryWrapper<>();
        qw.eq("product_id", id);
        Page<Shop> result = shopService.page(new Page<>(page, pageSize), qw);
        System.out.println(result.getRecords());
        return new PageVo(result.getRecords(), result.getTotal());
    }

    /**
     * 数据测试
     *
     * @param id
     * @param page
     * @param pageSize
     * @return
     */

    @GetMapping("/TestList/{id}")
    public PageVo Test01(@PathVariable("id") int id, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        QueryWrapper<Shop> qw1 = new QueryWrapper<>();
        qw1.eq("product_id", id);
        Page<Shop> result = shopService.page(new Page<>(page, pageSize), qw1);
        System.out.println(result.getRecords());
        return new PageVo(result.getRecords(), result.getTotal());
    }

    /**
     * 根据传输来的搜索关键词检索商品
     */
    @GetMapping("/searchGoods")
    public ResponseResult searchGoodsByKeyWords(@RequestParam("keyword") String keyword) {
        System.out.println(keyword);
        return ResponseResult.ok();
    }
}
