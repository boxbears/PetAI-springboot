package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddresses {
    private String id;
    private String receiver;
    private String contact;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String address;
    private Integer isDefault;
    private String fullLocation;
    private String postalCode;
    private String addressTags;
}
