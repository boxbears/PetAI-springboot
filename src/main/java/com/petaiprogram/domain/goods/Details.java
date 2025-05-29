package com.petaiprogram.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {
    private List<String> pictures;
    private List<Property> properties;
}
