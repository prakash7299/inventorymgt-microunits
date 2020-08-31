package com.dxctraining.inventorymgt.phone.util;

import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.phone.dto.PhoneDto;
import com.dxctraining.inventorymgt.phone.entities.Phone;


@Component
public class PhoneUtil {
	
	public PhoneDto phoneDto(Phone phone,String supplierId,String supplierName) {
		PhoneDto dto=new PhoneDto(phone.getId(),phone.getStorageMemory(),phone.getName());
		dto.setSupplierId(supplierId);
		dto.setSupplierName(supplierName);
		return dto;
	}

}
