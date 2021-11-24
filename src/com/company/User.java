package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class User extends IUser {

    private String phoneNum;
    private String email;
    //private Offer offer;
    public String getPhoneNum() {
        return phoneNum;
    }
    private boolean verified;
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getVerified(){
        return verified;
    }
    public String getEmail() {
        return email;
    }

/*
    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }*/



    public Ride requestRide(IArea s, IArea d) {
        Ride ride = new Ride(s, d);
        ride.checkSourceArea(s);
        return ride;
    }

    public Offer chooseOffer(ArrayList<Offer> offers) {
        System.out.println("Choose one of these offers");
        
        for (int i =1 ; i <= offers.size(); i++) {
            System.out.println(i  + ":" );
            offers.get(i-1).to_String();
        }
        System.out.println("Enter the no. of Offer you want:");
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
        return offers.get(choise-1);
        //this.setOffer(offers.get(choise - 1));

    }

    @Override
    public String toString() {
        return "User [userName="+getUserName()+"email=" + email + ", phoneNum=" + phoneNum + "]";
    }

    
}