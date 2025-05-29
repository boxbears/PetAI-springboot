package com.petaiprogram.mapper;

import com.petaiprogram.domain.User;
import com.petaiprogram.domain.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Profile;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface UserProfileMapper {

    //查找用户信息
    @Select("SELECT *from profile where id=#{id}")
    UserProfile findAll(int id);


    @Update("update profile set avatar = #{avatarUrl} where id = #{userId}")
    void updataAvatar(String avatarUrl,int userId);

    @Update("update profile set nickname=#{nickname},sex=#{sex},birthday=#{birthday},provinceCode=#{provinceCode},cityCode=#{cityCode},countyCode=#{countyCode},city=#{city}")
    void update(UserProfile userProfile);
}
