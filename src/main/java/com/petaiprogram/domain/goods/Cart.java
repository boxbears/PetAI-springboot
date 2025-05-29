package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String id;
    private String name;
    private String picture;
    private double price;
    private int count;
    private String skuId;
    private String attrsText;
    private boolean selected;
    private String userId;
    private boolean now;
}