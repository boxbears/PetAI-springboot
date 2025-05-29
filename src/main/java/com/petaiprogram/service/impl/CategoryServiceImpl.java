package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Category;
import com.petaiprogram.service.CategoryService;
import com.petaiprogram.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 27609
* @description 针对表【category(前台分类表)】的数据库操作Service实现
* @createDate 2023-11-29 13:34:25
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




