package com.dxctraining.inventorymgt.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.inventorymgt.supplier.dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;


@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier findById(Integer id) {
		Optional<Supplier> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new SupplierNotFoundException("supplier not found for id=" + id);
		}
		Supplier supplier = optional.get();
		return supplier;
	}
	

	@Override
	public Supplier add(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}
	
	@Override
	public List<Supplier> findBySname(String sname){
		List<Supplier> supplier=dao.findBySname(sname);
		return supplier;
	}

	@Override
	public void removeById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Supplier> allSuppliers() {
		List<Supplier> allsuppliers = dao.findAll();
		return allsuppliers;
	}


}
