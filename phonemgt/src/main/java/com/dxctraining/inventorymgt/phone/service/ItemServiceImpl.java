package com.dxctraining.inventorymgt.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.inventorymgt.phone.dao.IItemDao;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{
	@Autowired
    private IItemDao dao;
	
	@Override
    public Phone findPhoneById(int id) {
       Phone phone= dao.findPhoneById(id);
        return phone;
    }
	 @Override
	    public Phone update(Phone phone) {
	        validate(phone);
	        phone=dao.update(phone);
	        return phone;
	    }
	 @Override
	    public Phone add(Phone phone) {
	        validate(phone);
	        phone=dao.add(phone);
	        return phone;
	    }
	 @Override
	    public void removePhone(int id) {
	       dao.removePhone(id);
	    }
	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Argument is null change it");
	        }
	    }
	   @Override
	    public List<Phone> allPhone(){
	        List<Phone>allPhone=dao.allPhone();
	        return allPhone;
	    }
	   @Override
	    public List<Phone> allPhoneBySupplier(String supplierId){
	        List<Phone>list=dao.allPhoneBySupplier(supplierId);
	        return list;
	    }

}
