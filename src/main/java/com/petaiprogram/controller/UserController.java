package com.petaiprogram.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.petaiprogram.domain.Profile;
import com.petaiprogram.domain.User;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.ProfileService;
import com.petaiprogram.service.UserProfileService;
import com.petaiprogram.service.UserService;
import com.petaiprogram.utils.JwtUtil;
import com.petaiprogram.utils.RandomNumber;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/miniTest")
@Validated
public class UserController {
    /**
     * 模拟登录
     */
    @Autowired
    private UserService userService;
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    private ProfileService profileService;

    private int getUserId(String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        int useId = (int) map.get("id");
        return useId;
    }

    @PostMapping("/login/wxMin/simple")
    public ResponseResult LoginSimple(@RequestBody Map<String, String> requestBody) {
        String phoneNumber = requestBody.get("phoneNumber");
        //根据手机号查询用户
        User loginUser = userService.findByMobile(phoneNumber);
        //如果没有查询到
        if(loginUser == null){
            User user = new User();
            user.setMobile(phoneNumber);
            user.setId(Integer.parseInt(RandomNumber.getRandom(5)));
            user.setNickname("用户"+ RandomNumber.getRandom(3));
            user.setAccount(RandomNumber.getRandom(9));
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getNickname());
            String token = JwtUtil.getToken(claims);
            user.setToken(token);
            userService.addLogin(user);
            Profile profile = new Profile();
            profile.setId(user.getId());
            profile.setAccount(user.getAccount());
            profile.setAvatar(user.getAvatar());
            profile.setNickname(user.getNickname());
            profileService.save(profile);
            return ResponseResult.ok(user);
        }
        //如果查询到了
        if(!(loginUser ==null)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getNickname());
            String token = JwtUtil.getToken(claims);
            loginUser.setToken(token);
            userService.saveToken(token);
            return ResponseResult.ok(loginUser);
        }
        return ResponseResult.ok(loginUser);

    }

    /**
     * 获取用户基本个人信息
     */
    @GetMapping("/user/profile")
    public ResponseResult getProfile(@RequestParam("id") int id) {
        return ResponseResult.ok(profileService.getById(id));
    }

    /**
     * 更改个人头像
     */
    @PostMapping("/user/updateAvatar")
    public ResponseResult updateAvatar(@RequestParam("file") MultipartFile file,@RequestHeader("Authorization") String token) throws IOException {
        int userId = getUserId(token);

        if (file.isEmpty()) {
            System.out.println("Please select a file to upload");
        }
        //指定存储文件的目录
        String uploadDir = "src/main/resources/static/";

        //上传文件原始文件名
        String originalFilename = file.getOriginalFilename();

        //构建目标文件路径
        Path filePath = Path.of(uploadDir,originalFilename);

        //将文件保存到目标路径
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

        System.out.println(originalFilename);

        String onlineFilePath = "https://mfg8uf6pxn2i.ngrok,xiaomiqiu.top/top/uploads/"+originalFilename;

        userProfileService.updataAvatar(onlineFilePath,userId);
        userService.updateAvatar(onlineFilePath,userId);
        return ResponseResult.ok(onlineFilePath);
    }

    private String saveFileLocally(MultipartFile file) throws IOException {
        // 返回文件保存后的路径或其他标识
        // 例如，你可以使用UUID生成唯一文件名并保存到指定目录
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = "D:\\hzx" + fileName;//D:\hzx

        // 保存文件
        File destFile = new File(filePath);
        file.transferTo(destFile);

        return filePath;
    }
    @PutMapping("/update/profile")
    public ResponseResult updateName(@RequestBody Profile profile){

        UpdateWrapper<Profile> up = new UpdateWrapper<>();
        up.eq("id",profile.getId());
        up.set("avatar",profile.getAvatar());
        up.set("account",profile.getAccount()) ;
        up.set("nickname",profile.getNickname());
        up.set("sex",profile.getSex());
        up.set("birthday",profile.getBirthday());
        up.set("city",profile.getCity());
        profileService.update(up);
        User user = new User();
        user.setNickname(profile.getNickname());
        user.setAvatar(profile.getAvatar());
        userService.update(user);

        return ResponseResult.ok(profile);
    }

    @GetMapping("/test")
    public ResponseResult test(){
        return ResponseResult.ok("sxz是sb");
    }
}
