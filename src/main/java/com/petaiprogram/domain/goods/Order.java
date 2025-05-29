package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /** id */
    private String orderId;
    /** 所选地址Id */
    private String addressId;
    /** 配送时间类型，1为不限，2为工作日，3为双休或假日 */
    private int deliveryTimeType;
    /** 订单备注 */
    private String buyerMessage;
    /** 支付渠道：支付渠道，1支付宝、2微信--支付方式为在线支付时，传值，为货到付款时，不传值 */
    private int payChannel;
    /** 支付方式，1为在线支付，2为货到付款 */
    private int payType;
    /** 商品集合[ 商品信息 ] */
    private List<Cart> goods;
    private int orderState;
}
