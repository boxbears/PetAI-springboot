package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Profile;
import com.petaiprogram.service.ProfileService;
import com.petaiprogram.mapper.ProfileMapper;
import org.springframework.stereotype.Service;

/**
* @author 何智雄
* @description 针对表【profile】的数据库操作Service实现
* @createDate 2024-01-29 22:06:05
*/
@Service
public class ProfileServiceImpl extends ServiceImpl<ProfileMapper, Profile>
    implements ProfileService{

}




