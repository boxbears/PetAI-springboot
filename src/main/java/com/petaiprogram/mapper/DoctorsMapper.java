package com.petaiprogram.mapper;

import com.petaiprogram.domain.Doctors;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author dell
* @description 针对表【doctors】的数据库操作Mapper
* @createDate 2024-02-28 22:41:07
* @Entity com.petaiprogram.domain.Doctors
*/
@Mapper
public interface DoctorsMapper extends BaseMapper<Doctors> {

}




