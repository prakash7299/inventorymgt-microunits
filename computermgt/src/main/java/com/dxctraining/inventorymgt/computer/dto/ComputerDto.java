package com.dxctraining.inventorymgt.computer.dto;

public class ComputerDto {
	private int id;
	private int deskSpace;
	private String name;
	private String supplierId;
	private String supplierName;
	public ComputerDto() {
		
	}
	public ComputerDto(int id,int deskSpace,String name) {
		this.id=id;
		this.deskSpace=deskSpace;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
