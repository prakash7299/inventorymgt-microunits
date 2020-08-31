package com.dxctraining.inventorymgt.phone.dao;

import java.util.List;
import com.dxctraining.inventorymgt.phone.entities.Phone;

public interface IItemDao {
	Phone findPhoneById(int id);
    Phone add(Phone phone);
    Phone update(Phone phone);
    void removePhone(int id);
    List<Phone> allPhone();
    List<Phone> allPhoneBySupplier(String supplierId);
}
