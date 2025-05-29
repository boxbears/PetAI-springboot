package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrder {
    private Integer deliveryTimeType;
    private Integer payType;
    private Integer payChannel;
    private String totalPrice;
    private String totalPayPrice;
    private String buyerMessage;
    private List<SpecValue> goods;
    private String addressId;
}
