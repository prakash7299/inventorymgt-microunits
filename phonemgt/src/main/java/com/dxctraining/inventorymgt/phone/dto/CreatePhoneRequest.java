package com.dxctraining.inventorymgt.phone.dto;

public class CreatePhoneRequest {
	private String name;
	private int storageMemory;
	private String supplierId;
	private String supplierName;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStorageMemory() {
		return storageMemory;
	}
	public void setStorageMemory(int storageMemory) {
		this.storageMemory = storageMemory;
	}
	

}
