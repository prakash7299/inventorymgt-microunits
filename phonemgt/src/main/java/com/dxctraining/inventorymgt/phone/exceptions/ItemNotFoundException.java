package com.dxctraining.inventorymgt.phone.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String msg){
        super(msg);
    }

}
