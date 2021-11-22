package com.company;

import java.util.ArrayList;

public class User {
    private String phoneNum;
    private String email;


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Offer requestRide(IArea source, IArea dest){
        source=new Area();
        dest=new Area();
        Ride ride=new Ride(source, dest);
        




    }

    public void chooseOffer (ArrayList<Offer> offers){
        
    }

}