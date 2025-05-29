package com.petaiprogram.service.impl;

import com.petaiprogram.domain.UserProfile;
import com.petaiprogram.mapper.UserProfileMapper;
import com.petaiprogram.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;
    @Override
    public UserProfile findAll(int id) {
        UserProfile userProfile = userProfileMapper.findAll(id);
        return userProfile;
    }

    @Override
    public void updataAvatar(String avatarUrl,int userId) {
        userProfileMapper.updataAvatar(avatarUrl,userId);
    }

    @Override
    public void update(UserProfile userProfile) {
        userProfileMapper.update(userProfile);
    }

}
