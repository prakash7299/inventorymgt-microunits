package com.dxctraining.inventorymgt.phone.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.ItemNotFoundException;

@Repository
public class ItemDaoImpl implements IItemDao{
	@PersistenceContext
    private EntityManager entityManager;
	

	 @Override
	    public Phone findPhoneById(int id) {
	        Phone phone=entityManager.find(Phone.class,id);
	        if(phone==null){
	            throw new ItemNotFoundException("phone not found for id="+id);
	        }
	        return phone;
	    }
	 @Override
	    public Phone add(Phone phone) {
	        entityManager.persist(phone);
	        return phone;
	    }
	 @Override
	    public Phone update(Phone phone) {
	        phone=entityManager.merge(phone);
	        return phone;
	    }
	 @Override
	    public void removePhone(int id) {
	     Phone phone= findPhoneById(id) ;
	     entityManager.remove(phone);
	    }
	 @Override
	    public List<Phone> allPhone() {
	        String jpaql="from Phone";
	        System.out.println("inside 4");
	        TypedQuery<Phone>query=entityManager.createQuery(jpaql,Phone.class);
	        List<Phone>phoneList=query.getResultList();
	        return phoneList;
	    }
	 @Override
	    public List<Phone> allPhoneBySupplier(String supplierId) {
	        String jpaql="from Supplier where supplierId=:supplier";
	        TypedQuery<Phone>query=entityManager.createQuery(jpaql,Phone.class);
	        query.setParameter("supplier",supplierId);
	        List<Phone>computerList=query.getResultList();
	        return computerList;
	    }


}
