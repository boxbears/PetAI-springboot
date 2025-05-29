package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    /** id */
    private String id;
    /** 商品名称 */
    private String name;
    /** 商品描述 */
    private String desc;
    /** 当前价格 */
    private double price;
    /** 原价 */
    private double  oldPrice;
    /** 主图 */
    private String[] mainPictures;
    /** 商品详情: 包含详情属性 + 详情图片 */
    private Details details;
    /** 同类商品[ 商品信息 ] */
    private GoodsItem[] similarProducts;
    /** sku集合[ sku信息 ] */
    private SkuItem[] skus;
    /** 可选规格集合备注[ 可选规格信息 ] */
    private SpecItem[] specs;



}
