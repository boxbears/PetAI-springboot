package com.petaiprogram.domain.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spec {
    private String name;
    private String id;
    @JsonIgnore
    private String skuId;
    private List<SpecValue> values;
}
