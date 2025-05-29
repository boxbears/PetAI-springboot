package com.petaiprogram.controller;

import com.petaiprogram.domain.Community;
import com.petaiprogram.domain.UserProfile;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.CommunityService;
import com.petaiprogram.service.UserProfileService;
import com.petaiprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("miniTest")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/getCommunity")
    public ResponseResult getCommunityItem() {
        return ResponseResult.ok(communityService.list());
    }

    @GetMapping("/updateConcern")
    public void UpdateConcern(@RequestParam("itemId") int itemId,@RequestParam("newConcern") int newConcern){
        int concern = 0;
        if (newConcern == 0){
            concern = 1;
        }
        System.out.println("itemId: "+itemId);
        System.out.println("newConcern: "+ concern);
        Community community = communityService.getById(itemId);
        community.setConcern(concern);
        communityService.updateById(community);
    }

    @GetMapping("/setMoments")
    public void SetMoments(@RequestParam("titlecontent") String titlecontent, @RequestParam("info") String info, @RequestParam("picList") String[] picList, @RequestParam("userid")  int userid,@RequestParam("cityName")  String cityName, @RequestParam("choosePetId") int choosePetId){
        Community community = new Community();
        community.setUserid(userid);
        community.setText(info);
        community.setTitlecontent(titlecontent);
        community.setComName("小三");
        community.setConcern(0);
        community.setChoosepetid(choosePetId);
        String result = "";
        community.setComAva("https://pcapi-xiaotuxian-front-devtest.itheima.net/miniapp/uploads/avatar_3.jpg");
        community.setComIntro("我是帅哥");
         // 遍历数组并将元素按逗号间隔加在参数后面
        for (int i = 0; i < picList.length; i++) {
            result += picList[i];
            // 在除了最后一个元素之外的每个元素后面加上逗号
            if (i < picList.length - 1) {
                result += ",";
            }
        }
        String processedString = result.replaceAll("\\[|\\]|\"", "");
        System.out.println(processedString);
        community.setComPic(processedString);
        communityService.save(community);
    }
}
