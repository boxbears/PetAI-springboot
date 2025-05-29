package com.petaiprogram.mapper;

import com.petaiprogram.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //添加
    @Insert("insert into user(mobile) values(#{mobile})")
    void add(String mobile);

    //根据电话查找用户
    @Select("SELECT *from user where mobile=#{mobile}")
    User findByMobile(String mobile);

    @Update("update user set token = #{token}")
    void saveToken(String token);

    @Update("update user set nickname=#{nickname},avatar=#{avatar}")
    void update(User user);

    @Insert("insert into user(id,mobile,nickname,account,token) values(#{id},#{mobile},#{nickname},#{account},#{token})")
    void addLogin(User user);

    @Update("update user set avatar = #{onlineFilePath} where id = #{userId}")
    void updateAvatar(String onlineFilePath, int userId);
}
