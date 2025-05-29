package com.petaiprogram.mapper;

import com.petaiprogram.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【category(前台分类表)】的数据库操作Mapper
* @createDate 2023-11-29 13:34:25
* @Entity com.petaiprogram.domain.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




