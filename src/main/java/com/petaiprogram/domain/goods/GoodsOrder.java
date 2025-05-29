package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOrder {
    private String id;
    private String name;
    private String picture;
    private Integer count;
    private String skuId;
    private String attrsText;
    private String price;
    private String payPrice;
    private String totalPrice;
    private String totalPayPrice;
}
