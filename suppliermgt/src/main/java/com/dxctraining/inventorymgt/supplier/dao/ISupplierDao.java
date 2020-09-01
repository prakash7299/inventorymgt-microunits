package com.dxctraining.inventorymgt.supplier.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierDao extends MongoRepository<Supplier,String>{
	
	List<Supplier> findByName(String name);
 
}
