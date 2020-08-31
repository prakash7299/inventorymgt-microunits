package com.dxctraining.inventorymgt.phone.dto;

public class PhoneDto {
	private int id;
	private int storageMemory;
	private String name;
	private String supplierId;
	private String supplierName;
	public PhoneDto() {
		
	}
	public PhoneDto(int id,int deskSpace,String itemName) {
		this.id=id;
		this.storageMemory=deskSpace;
		this.name=itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeskSpace() {
		return storageMemory;
	}
	public void setDeskSpace(int deskSpace) {
		this.storageMemory = deskSpace;
	}
	public String getItemName() {
		return name;
	}
	public void setItemName(String itemName) {
		this.name = itemName;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	

}
