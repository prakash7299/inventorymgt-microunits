package com.dxctraining.inventorymgt.computer.dto;

public class CreateComputerRequest {
	private int deskSpace;
	private String name;
	private String supplierName;
	private String supplierId;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public int getDeskSpace() {
		return deskSpace;
	}
	public void setDeskSpace(int deskSpace) {
		this.deskSpace = deskSpace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	

}
