package com.dxctraining.inventorymgt.supplier.entities;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Supplier {
	@Id
	private String id;
	private String sname;
	private String password;

	public Supplier() {

	}


	public Supplier(String sname, String password) {
		this.sname = sname;
		this.password = password;
	}

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return sname;
	}

	public void setName(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	

	

}
