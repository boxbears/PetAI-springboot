package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecItem {
    /** 规格名称 */
    private String name;
    /** 可选值集合[ 可选值信息 ] */
    private SpecValueItem[] values;
}
