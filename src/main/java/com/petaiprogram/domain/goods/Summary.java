package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    private Integer goodsCount;
    private Integer totalPrice;
    private Integer totalPayPrice;
    private Integer postFee;
    private Integer discountPrice;
}
