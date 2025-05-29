package com.petaiprogram.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.petaiprogram.domain.Profile;
import com.petaiprogram.domain.User;

public interface UserService {
    void register(String mobile);

    User findByMobile(String mobile);

    void saveToken(String token);

    void update(User user);

    void addLogin(User user);

    void updateAvatar(String onlineFilePath,int userId);
}
