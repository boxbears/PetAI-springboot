package com.petaiprogram.domain.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodDetails {
    private String id;
    private String name;
    private String skuCode;
    private String desc;
    private String price;
    private String oldPrice;
    private String picture;
    private String discount;
    private Integer inventory;
    private Brand brand;
    private Integer salesCount;
    private List<String> mainPictures;
    private List<Spec> specs;
    private List<Sku> skus;
    private Details details;
    private List<SimilarProducts> similarProducts;
    @JsonIgnore
    private Integer brandId;
    @JsonIgnore
    private Integer typeId;
}
