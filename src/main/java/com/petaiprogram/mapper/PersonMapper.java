package com.petaiprogram.mapper;

import com.petaiprogram.domain.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【person(人物表)】的数据库操作Mapper
* @createDate 2023-10-30 16:20:06
* @Entity com.wangfei.domain.Person
*/
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}




