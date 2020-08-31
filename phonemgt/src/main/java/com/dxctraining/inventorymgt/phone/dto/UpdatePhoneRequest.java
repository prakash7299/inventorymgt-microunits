package com.dxctraining.inventorymgt.phone.dto;

public class UpdatePhoneRequest {
	private int id;
	private int storageMemory;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStorageMemory() {
		return storageMemory;
	}
	public void setStorageMemory(int storageMemory) {
		this.storageMemory = storageMemory;
	}
	public String getItemName() {
		return name;
	}
	public void setItemName(String itemName) {
		this.name = itemName;
	}
	

}
