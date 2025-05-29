package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Person;
import com.petaiprogram.service.PersonService;
import com.petaiprogram.mapper.PersonMapper;
import org.springframework.stereotype.Service;

/**
* @author 27609
* @description 针对表【person(人物表)】的数据库操作Service实现
* @createDate 2023-10-30 16:20:06
*/
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person>
    implements PersonService{

}




