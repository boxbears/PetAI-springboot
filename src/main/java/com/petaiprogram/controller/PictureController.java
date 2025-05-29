package com.petaiprogram.controller;

import com.petaiprogram.domain.Picture;
import com.petaiprogram.domain.dto.PictureAsFour;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/getPetPicture")
    public ResponseResult getAllPicture() {

        System.out.println("图片集合的长度为:" + pictureService.list().size());
        List<PictureAsFour> pictureAsFourList = new ArrayList<>();
        int listSize = 0;
        if(pictureService.list().size()%4==0){
            listSize=pictureService.list().size()/4;
        }else {
            listSize=pictureService.list().size()/4+1;
        }
        int k = 0;
        for (int i = 0; i < listSize; i++) {
            PictureAsFour pictureAsFour = new PictureAsFour();
            if(k<pictureService.list().size()){
                pictureAsFour.setFirst(pictureService.list().get(k++).getImgurl());
            }
            if(k<pictureService.list().size()){
                pictureAsFour.setSecond(pictureService.list().get(k++).getImgurl());
            }
            if(k<pictureService.list().size()){
                pictureAsFour.setThird(pictureService.list().get(k++).getImgurl());
            }
            if(k<pictureService.list().size()){
                pictureAsFour.setForth(pictureService.list().get(k++).getImgurl());
            }
            pictureAsFourList.add(pictureAsFour);

            System.out.println("四宫格宠物照片："+pictureAsFour);
        }
        System.out.println(pictureAsFourList);
        return ResponseResult.ok(pictureAsFourList);
    }
}
/**
 * // 宠物的图片
 * export type PetPictures = {
 * first: string
 * second: string
 * third: string
 * forth: string
 * }
 */