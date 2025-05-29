package com.petaiprogram.mapper;

import com.petaiprogram.domain.Profile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何智雄
* @description 针对表【profile】的数据库操作Mapper
* @createDate 2024-01-29 22:06:05
* @Entity com.petaiprogram.domain.Profile
*/
@Mapper
public interface ProfileMapper extends BaseMapper<Profile> {

}




