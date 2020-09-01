package com.dxctraining.inventorymgt.supplier.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;


@DataJpaTest
@Import(SupplierServiceImpl.class)
public class SupplierServiceImplTest {

	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private RestTemplate rest;
	
	@Test
	public void testSave_1() {
		String name="prakash";
		String password="12345";
		Supplier supplier1=new Supplier(name,password);
		supplier1=supplierService.add(supplier1);
		int id=supplier1.getId();
		Supplier fetched=supplierService.findById(id);
		Assertions.assertEquals(supplier1.getId(),fetched.getId());
		Assertions.assertEquals(supplier1.getName(),fetched.getName());
		Assertions.assertEquals(supplier1.getPassword(), fetched.getPassword());
		
	}
	@Test
	public void testFindById_1() {
		String name="praveen";
		String password="abcde";
		Supplier supplier1=new Supplier(name,password);
		supplier1=supplierService.add(supplier1);
		int id=supplier1.getId();
		Supplier fetched=supplierService.findById(id);
		Assertions.assertEquals(supplier1.getId(),fetched.getId());
		Assertions.assertEquals(supplier1.getName(),fetched.getName());
		Assertions.assertEquals(supplier1.getPassword(), fetched.getPassword());
		
	}
	
	
	
}
