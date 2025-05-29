package com.petaiprogram.mapper;

import com.petaiprogram.domain.Questions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【questions】的数据库操作Mapper
* @createDate 2024-05-16 17:08:51
* @Entity com.petaiprogram.domain.Questions
*/
@Mapper
public interface QuestionsMapper extends BaseMapper<Questions> {

}




