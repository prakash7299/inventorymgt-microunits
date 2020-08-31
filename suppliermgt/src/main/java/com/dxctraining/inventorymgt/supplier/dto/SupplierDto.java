package com.dxctraining.inventorymgt.supplier.dto;

public class SupplierDto {
	private String id;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
  
}
