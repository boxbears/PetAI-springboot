package com.petaiprogram.controller;


import com.petaiprogram.domain.*;

import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@RestController
@RequestMapping("/miniTest")
public class TestController {
    @Autowired
    private PictureService pictureService;

    /**
     * distributionSite
     * 使用/home/swiper{distributionSite}接收数据一般用来接收id如{id}
     * 需前端使用${id}发送请求，在后端的路径后面需跟上{id}并且在方法中使用@PathVariable接收
     * id
     * 使用该种方法接收数据，一般时发送get请求时data里面的数据按照xxx?username=张三&age=13这种格式拼接在请求后面
     * 使用@RequestParam接收
     *
     * @GetMapping("/home/swiper{id}") public ResponseResult getHomeSwiperPicture(@PathVariable("id") int id)
     */
    @GetMapping("/home/swiper")
    public ResponseResult getHomeSwiperPicture(@RequestParam("distributionSite") int distributionSite) {
        System.out.println("distributionSite:" + distributionSite);
        List<Picture> list = pictureService.list();
        return ResponseResult.ok(list);
    }

    /**
     * 首页-前台分类-小程序
     * 图标路径| icon:string
     * id | id:string
     * 分类名称 | name:string
     */
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home/category/mutli")
    public ResponseResult getHomeCategoryMutli() {
        return ResponseResult.ok(categoryService.list());
    }

    @GetMapping("/home/hot/mutli")
    public ResponseResult getHomeHotMutli() {
        return ResponseResult.ok();
    }

    @Autowired
    private PersonService personService;

    @GetMapping("/MyInformation")
    public ResponseResult getMyInformation() {
        return ResponseResult.ok(personService.list());
    }


    @Autowired
    private ProdcutDetailService prodcutDetailService;
    private GuesslikeService guesslikeService;
}