package com.dxctraining.inventorymgt.computer.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String msg){
        super(msg);
    }

}
