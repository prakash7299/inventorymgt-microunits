package com.dxctraining.inventorymgt.supplier.service;

import java.util.List;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {
	Supplier findById(Integer id);
    Supplier add(Supplier supplier);
    void removeById(Integer id);
    List<Supplier> allSuppliers();
    List<Supplier> findBySname(String sname);
}
