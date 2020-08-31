package com.dxctraining.inventorymgt.computer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.inventorymgt.computer.dao.IItemDao;
import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{
	@Autowired
    private IItemDao dao;
	
	@Override
    public Computer findComputerById(int id) {
       Computer computer= dao.findComputerById(id);
        return computer;
    }
	 @Override
	    public Computer add(Computer computer) {
	        validate(computer);
	        computer=dao.add(computer);
	        return computer;
	    }
	 @Override
	    public Computer update(Computer computer) {
	        validate(computer);
	        computer=dao.update(computer);
	        return computer;
	    }
	 @Override
	    public void removeComputer(int id) {
	       dao.removeComputer(id);
	    }
	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Argument is null change it");
	        }
	    }
	   @Override
	    public List<Computer> allComputer(){
	        List<Computer>allcomputer=dao.allComputer();
	        return allcomputer;
	    }
	   @Override
	    public List<Computer> allComputerBySupplier(String supplierId){
	        List<Computer>list=dao.allComputerBySupplier(supplierId);
	        return list;
	    }

}
