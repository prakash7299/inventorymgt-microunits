package com.dxctraining.inventorymgt.supplier.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionData {
    private String id="-1";
    private boolean userLoggedIn;
    public SessionData(String id){
        this.id=id;
    }
    public SessionData(){
        this.id=id;
    }
    public String getId() {
        return id;
  }
    public void saveLogin(String id){
        this.userLoggedIn=true;
        this.id=id;
    }
    public void  clear(){
        id="-1";
        userLoggedIn=false;
    }

    public boolean isUserLoggedIn(){
        return userLoggedIn;
    }
}
