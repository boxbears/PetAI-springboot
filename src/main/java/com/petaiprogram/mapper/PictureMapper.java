package com.petaiprogram.mapper;

import com.petaiprogram.domain.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【picture】的数据库操作Mapper
* @createDate 2024-02-01 22:46:44
* @Entity com.petaiprogram.domain.Picture
*/
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

}




