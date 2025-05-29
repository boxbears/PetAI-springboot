package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private String id;
    private String createTime;
    private Integer orderState;
    private List<Sku1> skus;
    private Integer postFee;
    private Integer payMoney;
    private Integer totalMoney;
}
