package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Petbaseinformation;
import com.petaiprogram.service.PetbaseinformationService;
import com.petaiprogram.mapper.PetbaseinformationMapper;
import org.springframework.stereotype.Service;

/**
* @author 27609
* @description 针对表【petbaseinformation(宠物基本信息)】的数据库操作Service实现
* @createDate 2024-02-28 23:35:05
*/
@Service
public class PetbaseinformationServiceImpl extends ServiceImpl<PetbaseinformationMapper, Petbaseinformation>
    implements PetbaseinformationService{

}




