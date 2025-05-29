package com.petaiprogram.domain.vo;

import com.petaiprogram.domain.dto.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2023/12/09  15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendData<T> {
//    类型ID
    private int id;
//    传输的商品类型
    private String name;
//    商品数据
    private PageDTO<T> goodsItems;
}
