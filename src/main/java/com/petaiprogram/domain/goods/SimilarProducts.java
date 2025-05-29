package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarProducts {
    private String id;
    private String name;
    private String desc;
    private String price;
    private String picture;
    private String discount;
    private Integer orderNum;
}
