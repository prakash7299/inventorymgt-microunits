package com.dxctraining.inventorymgt.computer.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="computers_information")
public class Computer {
	@Id
	@GeneratedValue
	private int id;
	private int deskSpace;
	private String name;
	private String supplierName;
	private String supplierId;
	public Computer() {
		
	}
	public Computer(String name,int deskSpace,String supplierId){
		this.name=name;
		this.deskSpace=deskSpace;
		this.supplierId=supplierId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer that = (Computer) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
	
	

}
