package com.petaiprogram.service;

import com.petaiprogram.domain.UserProfile;
import org.springframework.web.multipart.MultipartFile;


public interface UserProfileService {
    UserProfile findAll(int id);

    //更新头像
    void updataAvatar(String avatarUrl,int userId);

    void update(UserProfile userProfile);
}
