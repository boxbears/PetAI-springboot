package com.petaiprogram.domain.goods;

import lombok.Data;

@Data
public class PayOrder {
    private String id;
    private String createTime;
    private int payType = 1; // 默认支付方式为1
    private int orderState = 1; // 默认订单状态为1
    private String payLatestTime;
    private int postFee = 5; // 默认邮费为5
    private Integer payMoney; // 订单实付金额
    private Integer totalMoney; // 订单金额合计
    private Integer totalNum; // 订单数量合计
    private int payChannel = 1; // 默认支付渠道为1
    private Integer countdown; // 订单倒计时
}
