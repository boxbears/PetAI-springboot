package com.petaiprogram.service.impl;

import com.petaiprogram.domain.goods.AddressItem;
import com.petaiprogram.mapper.AddressMapper;
import com.petaiprogram.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;



    @Override
    public void add(AddressItem addressItem) {
        addressMapper.add(addressItem);
    }

//    @Override
//    public AddressItem findById(String id,int userId) {
//        AddressItem addressItem = new AddressItem();
//        addressItem = addressMapper.findById(id,userId);
//        return addressItem;
//    }

    @Override
    public List<AddressItem> findAll(int userId) {
        List<AddressItem> addressItems = addressMapper.findAll(userId);
        return addressItems;
    }
}
