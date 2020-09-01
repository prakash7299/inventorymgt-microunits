package com.dxctraining.inventorymgt.supplier.dto;

public class CreateSupplierRequest {
	private String sname;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return sname;
	}

	public void setName(String name) {
		this.sname = name;
	}
	

}
