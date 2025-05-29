package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku1 {
    private String skuId;
    private String picture;
    private String name;
    private String attrsText;
    private String price;
    private Integer count;
}
