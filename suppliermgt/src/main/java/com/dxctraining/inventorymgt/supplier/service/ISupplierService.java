package com.dxctraining.inventorymgt.supplier.service;

import java.util.List;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {
	Supplier findById(String id);

    Supplier add(Supplier supplier);

    void removeById(String id);
    List<Supplier> allSuppliers();

}
