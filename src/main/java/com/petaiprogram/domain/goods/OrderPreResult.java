package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPreResult {
    /** 商品集合 [ 商品信息 ] */
    private List<Sku1> goods;
    /** 结算信息 */
    private Summary summary;
    /** 用户地址列表 [ 地址信息 ] */
    private List<AddressItem> userAddresses;
}
