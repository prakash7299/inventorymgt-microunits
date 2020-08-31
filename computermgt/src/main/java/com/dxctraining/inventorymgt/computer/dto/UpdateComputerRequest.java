package com.dxctraining.inventorymgt.computer.dto;

public class UpdateComputerRequest {
	private int id;
	private int deskSpace;
	private String name;
	
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
	

}
