package com.company;

public abstract class IUser {
    protected String userName ;
    
    protected String password ;

    public IUser() {
    }

    public IUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }



}