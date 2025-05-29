package com.petaiprogram.service.impl;

import com.petaiprogram.domain.User;
import com.petaiprogram.mapper.UserMapper;
import com.petaiprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String mobile) {
        //企业开发需要加密
        //添加
        userMapper.add(mobile);
    }

    @Override
    public User findByMobile(String mobile) {
        User u = userMapper.findByMobile(mobile);
        return u;
    }

    @Override
    public void saveToken(String token) {
        userMapper.saveToken(token);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void addLogin(User user) {
        userMapper.addLogin(user);
    }

    @Override
    public void updateAvatar(String onlineFilePath, int userId) {
        userMapper.updateAvatar(onlineFilePath,userId);
    }


}
