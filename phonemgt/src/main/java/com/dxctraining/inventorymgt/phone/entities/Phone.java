package com.dxctraining.inventorymgt.phone.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Phones_information")
public class Phone{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int storageMemory;
	private String supplierId;
	private String supplierName;
	public Phone() {
		
	}
	public Phone(String name,int storageMemory,String supplierId) {
		this.name=name;
		this.storageMemory=storageMemory;
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
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStorageMemory() {
		return storageMemory;
	}
	public void setStorageSpace(int storageMemory) {
		this.storageMemory = storageMemory;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone that = (Phone) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
