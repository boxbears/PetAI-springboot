package com.petaiprogram.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2023/12/09  15:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendVo {
//    名称
    private String name;
    private ArrayList<RecommendData> items;
}
