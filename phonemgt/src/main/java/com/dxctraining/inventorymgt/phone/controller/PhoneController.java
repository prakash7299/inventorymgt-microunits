package com.dxctraining.inventorymgt.phone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.phone.dto.PhoneDto;
import com.dxctraining.inventorymgt.phone.dto.SupplierDto;
import com.dxctraining.inventorymgt.phone.dto.UpdatePhoneRequest;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IItemService;
import com.dxctraining.inventorymgt.phone.util.PhoneUtil;



@RestController
@RequestMapping("/phones")
public class PhoneController {
	@Autowired
	private IItemService service;
	
	@Autowired
	private PhoneUtil phoneUtil;

	@Autowired
	private RestTemplate restTemp;
	
	
	 @PostMapping(value = "/add")
	    @ResponseStatus(HttpStatus.CREATED)
	    public PhoneDto create(@RequestBody @Valid CreatePhoneRequest requestData) {
	        String name = requestData.getName();
	        int storageMemory = requestData.getStorageMemory();
	        String supplierId = requestData.getSupplierId();
	        Phone phone = new Phone(name,storageMemory,supplierId);
	        phone = service.add(phone);
	        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
	        PhoneDto res=phoneUtil.phoneDto(phone,supplier.getId(),supplier.getName());
	        return res;
	    }
	 @GetMapping("/get/{id}")
	    public PhoneDto findPhone(@PathVariable("id") int id) {
	        Phone phone = service.findPhoneById(id);
	        String supplierId = phone.getSupplierId();
	        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
	        PhoneDto response = phoneUtil.phoneDto(phone, supplierId,supplier.getName());
	        return response;
	    }
	 @GetMapping
	    public List<PhoneDto> fetchAll() {
	        List<Phone> list = service.allPhone();
	        List<PhoneDto>response=new ArrayList<>();
	        for (Phone phone:list){
	            String  supplierId=phone.getSupplierId();
	            SupplierDto supplier= fetchFromSupplierAppById(supplierId);
	            PhoneDto dto=phoneUtil.phoneDto(phone,supplierId,supplier.getName());
	            response.add(dto);
	        }
	        return response;
	    }
	 @GetMapping("/suppliers/{supplierId}")
	    public List<PhoneDto> fetchAllForSupplier(@PathVariable("supplierId") String supplierId) {
	        List<Phone> list = service.allPhoneBySupplier(supplierId);
	        List<PhoneDto>response=new ArrayList<>();
	        SupplierDto supplier= fetchFromSupplierAppById(supplierId);
	        for (Phone phone:list){
	            PhoneDto dto=phoneUtil.phoneDto(phone,supplierId,supplier.getName());
	            response.add(dto);
	        }
	        return response;
	    }
	 @PutMapping("/update")
	    public PhoneDto updateComputer(@RequestBody @Valid UpdatePhoneRequest requestData) {
	        String name = requestData.getItemName();
	        int storageMemory = requestData.getStorageMemory();
	        int id = requestData.getId();
	        Phone phone = service.findPhoneById(id);
	        phone.setName(name);;
	        phone.setStorageSpace(storageMemory);;
	        phone = service.update(phone);
	        SupplierDto supplier=fetchFromSupplierAppById(phone.getSupplierId());
	        PhoneDto response = phoneUtil.phoneDto(phone, supplier.getId(), supplier.getName());
	        return response;
	    }
	 public SupplierDto fetchFromSupplierAppById(String supplierId) {
	        String url = "http://localhost:8585/suppliers/get/" + supplierId;
	        SupplierDto dto = restTemp.getForObject(url, SupplierDto.class);
	        return dto;
	    }


}
