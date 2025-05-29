package com.petaiprogram.mapper;

import com.petaiprogram.domain.Petbaseinformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 27609
* @description 针对表【petbaseinformation(宠物基本信息)】的数据库操作Mapper
* @createDate 2024-02-28 23:35:05
* @Entity com.petaiprogram.domain.Petbaseinformation
*/
@Mapper
public interface PetbaseinformationMapper extends BaseMapper<Petbaseinformation> {

}




