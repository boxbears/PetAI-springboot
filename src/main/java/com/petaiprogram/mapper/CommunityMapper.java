package com.petaiprogram.mapper;

import com.petaiprogram.domain.Community;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author dell
* @description 针对表【community】的数据库操作Mapper
* @createDate 2024-03-01 23:02:50
* @Entity com.petaiprogram.domain.Community
*/
@Mapper
public interface CommunityMapper extends BaseMapper<Community> {

}




