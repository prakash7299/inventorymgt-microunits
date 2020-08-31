package com.dxctraining.inventorymgt.computer.service;

import java.util.List;

import com.dxctraining.inventorymgt.computer.entities.Computer;

public interface IItemService {
	Computer findComputerById(int id);
    Computer add(Computer Computer);

    void removeComputer(int id);

    List<Computer> allComputer();
    List<Computer> allComputerBySupplier(String supplierId);
    Computer update(Computer computer);
  
}
