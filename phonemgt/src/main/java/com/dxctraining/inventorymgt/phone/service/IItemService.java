package com.dxctraining.inventorymgt.phone.service;

import java.util.List;

import com.dxctraining.inventorymgt.phone.entities.Phone;

public interface IItemService {
	Phone findPhoneById(int id);
  
    Phone add(Phone phone);
    Phone update(Phone phone);
    List<Phone> allPhoneBySupplier(String id);
    
    void removePhone(int id);
    
    List<Phone> allPhone();
}
