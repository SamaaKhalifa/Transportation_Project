package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends IUser {
    private String phoneNum;
    private String email;
    private Offer offer;

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public ArrayList<Offer> requestRide(IArea source, IArea dest) {
        source = new Area();
        dest = new Area();
        Ride ride = new Ride(source, dest);
        return  ride.checkSourceArea(source);

    }

    public void chooseOffer(ArrayList<Offer> offers) {
        System.out.println("Choose one of these offers");
        
        for (int i = 0; i < offers.size(); i++) {
            System.out.println(i + 1 + ":" + offers.indexOf(i));
        }
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
        this.setOffer(offers.get(choise - 1));

    }

    @Override
    public String toString() {
        return "User [email=" + email + ", offer=" + offer + ", phoneNum=" + phoneNum + "]";
    }

    
}