package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Doctors;
import com.petaiprogram.service.DoctorsService;
import com.petaiprogram.mapper.DoctorsMapper;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【doctors】的数据库操作Service实现
* @createDate 2024-02-28 22:41:07
*/
@Service
public class DoctorsServiceImpl extends ServiceImpl<DoctorsMapper, Doctors>
    implements DoctorsService{

}




