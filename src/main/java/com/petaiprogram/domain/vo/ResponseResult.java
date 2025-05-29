package com.petaiprogram.domain.vo;

import com.petaiprogram.domain.dto.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private Object result;

    public static ResponseResult ok() {
        return new ResponseResult(200, "操作成功", null);
    }

    public static ResponseResult ok(Object object) {
        return new ResponseResult(200, "操作成功", object);
    }

    public static ResponseResult ok(PageDTO<?> pageDTO) {
        return new ResponseResult(200, "操作成功", pageDTO);
    }

    public static ResponseResult error(Integer code, String msg) {
        return new ResponseResult(code, msg, null);
    }

}
