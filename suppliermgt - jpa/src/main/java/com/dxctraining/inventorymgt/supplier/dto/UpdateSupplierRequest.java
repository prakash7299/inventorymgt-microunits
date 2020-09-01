package com.dxctraining.inventorymgt.supplier.dto;

public class UpdateSupplierRequest {
	private Integer id;
	private String sname;
	private String password;
	public String getName() {
		return sname;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.sname = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
