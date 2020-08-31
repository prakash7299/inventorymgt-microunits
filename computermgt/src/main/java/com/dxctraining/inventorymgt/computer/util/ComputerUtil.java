package com.dxctraining.inventorymgt.computer.util;

import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.computer.dto.ComputerDto;
import com.dxctraining.inventorymgt.computer.entities.Computer;

@Component
public class ComputerUtil {
	
	public ComputerDto computerDto(Computer computer,String supplierId,String supplierName) {
		ComputerDto dto=new ComputerDto(computer.getId(),computer.getDeskSpace(),computer.getName());
		dto.setSupplierId(supplierId);
		dto.setSupplierName(supplierName);
		return dto;
	}

}
