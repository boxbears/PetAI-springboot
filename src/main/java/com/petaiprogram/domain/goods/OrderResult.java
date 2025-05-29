package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResult {
    private String orderId;
    private int orderState;
    private int countdown;
    private String skuId;
    private String name;
    private String attrsText;
    private int count;
    private double price;
    private String picture;
    private String receiver;
    private String receiverMobile;
    private String receiverAddress;
    private Date createTime;
    private double totalMoney;
    private double postFee;
    private double payMoney;
}
