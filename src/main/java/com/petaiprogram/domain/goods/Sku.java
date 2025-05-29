package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku {
    private String id;
    private String skuCode;
    private String price;
    private String oldPrice;
    private Integer inventory;
    private String picture;
    private Integer goodId;
    private List<Spec2> specs;
}
