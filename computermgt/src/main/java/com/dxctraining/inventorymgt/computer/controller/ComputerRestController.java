package com.dxctraining.inventorymgt.computer.controller;

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
import com.dxctraining.inventorymgt.computer.dto.ComputerDto;
import com.dxctraining.inventorymgt.computer.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.computer.dto.SupplierDto;
import com.dxctraining.inventorymgt.computer.dto.UpdateComputerRequest;
import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IItemService;
import com.dxctraining.inventorymgt.computer.util.ComputerUtil;

@RestController
@RequestMapping("/computers")
public class ComputerRestController {
	@Autowired
	private IItemService service;
	
	@Autowired
	private ComputerUtil computerUtil;

	@Autowired
	private RestTemplate restTemp;

	 @PostMapping(value = "/add")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ComputerDto create(@RequestBody @Valid CreateComputerRequest requestData) {
	        String name = requestData.getName();
	        int deskSpace = requestData.getDeskSpace();
	        String supplierId = requestData.getSupplierId();
	        Computer computer = new Computer(name,deskSpace,supplierId);
	        computer = service.add(computer);
	        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
	        ComputerDto res=computerUtil.computerDto(computer,supplier.getId(),supplier.getName());
	        return res;
	    }
	 @GetMapping("/get/{id}")
	    public ComputerDto findComputer(@PathVariable("id") int id) {
	        Computer computer = service.findComputerById(id);
	        String supplierId = computer.getSupplierId();
	        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
	        ComputerDto response = computerUtil.computerDto(computer, supplierId,supplier.getName());
	        return response;
	    }
	 @GetMapping
	    public List<ComputerDto> fetchAll() {
	        List<Computer> list = service.allComputer();
	        List<ComputerDto>response=new ArrayList<>();
	        for (Computer computer:list){
	            String  supplierId=computer.getSupplierId();
	            SupplierDto supplier= fetchFromSupplierAppById(supplierId);
	            ComputerDto dto=computerUtil.computerDto(computer,supplierId,supplier.getName());
	            response.add(dto);
	        }
	        return response;
	    }
	 @GetMapping("/suppliers/{supplierId}")
	    public List<ComputerDto> fetchAllForSupplier(@PathVariable("supplierId") String supplierId) {
	        List<Computer> list = service.allComputerBySupplier(supplierId);
	        List<ComputerDto>response=new ArrayList<>();
	        SupplierDto supplier= fetchFromSupplierAppById(supplierId);
	        for (Computer computer:list){
	            ComputerDto dto=computerUtil.computerDto(computer,supplierId,supplier.getName());
	            response.add(dto);
	        }
	        return response;
	    }
	 @PutMapping("/update")
	    public ComputerDto updateComputer(@RequestBody @Valid UpdateComputerRequest requestData) {
	        String name = requestData.getName();
	        int deskSpace = requestData.getDeskSpace();
	        int id = requestData.getId();
	        Computer computer = service.findComputerById(id);
	        computer.setName(name);
	        computer.setDeskSpace(deskSpace);
	        computer = service.update(computer);
	        SupplierDto supplier=fetchFromSupplierAppById(computer.getSupplierId());
	        ComputerDto response = computerUtil.computerDto(computer, supplier.getId(), supplier.getName());
	        return response;
	    }
	 public SupplierDto fetchFromSupplierAppById(String supplierId) {
	        String url = "http://localhost:8585/suppliers/get/" + supplierId;
	        SupplierDto dto = restTemp.getForObject(url, SupplierDto.class);
	        return dto;
	    }


}
