package com.petaiprogram.exception;

import com.petaiprogram.domain.vo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e){
        e.printStackTrace();
        return ResponseResult.error(0,"操作失败");
    }
}
