package com.dxctraining.inventorymgt.computer.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.exceptions.ItemNotFoundException;

@Repository
public class ItemDaoImpl implements IItemDao{
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public Computer findComputerById(int id) {
	        Computer computer=entityManager.find(Computer.class,id);
	        if(computer==null){
	            throw new ItemNotFoundException("computer not found for id="+id);
	        }
	        return computer;
	    }
	 @Override
	    public Computer add(Computer computer) {
	        entityManager.persist(computer);
	        return computer;
	    }
	 @Override
	    public Computer update(Computer computer) {
	        computer=entityManager.merge(computer);
	        return computer;
	    }
	 @Override
	    public void removeComputer(int id) {
	     Computer computer= findComputerById(id) ;
	     entityManager.remove(computer);
	    }
	 @Override
	    public List<Computer> allComputer() {
	        String jpaql="from Computer";
	        TypedQuery<Computer>query=entityManager.createQuery(jpaql,Computer.class);
	        List<Computer>computerList=query.getResultList();
	        return computerList;
	    }
	 @Override
	    public List<Computer> allComputerBySupplier(String supplierId) {
	        String jpaql="from Supplier where supplierId=:supplier";
	        TypedQuery<Computer>query=entityManager.createQuery(jpaql,Computer.class);
	        query.setParameter("supplier",supplierId);
	        List<Computer>computerList=query.getResultList();
	        return computerList;
	    }

}
