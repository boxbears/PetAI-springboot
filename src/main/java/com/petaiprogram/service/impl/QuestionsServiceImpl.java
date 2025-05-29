package com.petaiprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petaiprogram.domain.Questions;
import com.petaiprogram.service.QuestionsService;
import com.petaiprogram.mapper.QuestionsMapper;
import org.springframework.stereotype.Service;

/**
* @author 27609
* @description 针对表【questions】的数据库操作Service实现
* @createDate 2024-05-16 17:08:51
*/
@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions>
    implements QuestionsService{

}




