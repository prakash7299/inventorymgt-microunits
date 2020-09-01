package com.dxctraining.inventorymgt.supplier.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierDao extends JpaRepository<Supplier,Integer>{
	List<Supplier> findBySname(String sname);
 
}
