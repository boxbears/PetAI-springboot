package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOrders {
    private String id;
    private String createTime;
    private Integer payType;
    private Integer orderState;
    private String payLatestTime;
    private Integer postFee;
    private Integer payMoney;
    private Integer totalMoney;
    private Integer totalNum;
    private List<Sku> skus;
    private Integer payChannel;
    private Integer countdown;
    private String skuIds;
    private String SkuCounts;
    private String userId;
}
