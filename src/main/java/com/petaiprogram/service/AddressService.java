package com.petaiprogram.service;

import com.petaiprogram.domain.goods.AddressItem;

import java.util.Collection;
import java.util.List;

public interface AddressService {


    void add(AddressItem addressItem);

//    AddressItem findById(String id, int userId);

    List<AddressItem> findAll(int userId);
}
