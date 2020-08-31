package com.dxctraining.inventorymgt.computer.dao;

import java.util.List;

import com.dxctraining.inventorymgt.computer.entities.Computer;

public interface IItemDao {
	Computer findComputerById(int id);
    Computer add(Computer Computer);
    void removeComputer(int id);
    List<Computer> allComputer();
    List<Computer> allComputerBySupplier(String supplierId);
    Computer update(Computer computer);
   
}
