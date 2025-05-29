package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkuSpecItem {
    /** 规格名称 */
    private String name;
    /** 可选值名称 */
    private String valueName;
}
