package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressItem {
    /** 收货人姓名 */
    private String receiver;
    /** 联系方式 */
    private String contact;
    /** 省份编码 */
    private String provinceCode;
    /** 城市编码 */
    private String cityCode;
    /** 区/县编码 */
    private String countyCode;
    /** 详细地址 */
    private String address;
    /** 默认地址，1为是，0为否 */
    private int isDefault;
    /** 收货地址 id */
    private String id;
    /** 省市区 */
    private String fullLocation;
    /** userId */
    private int userId;
}
