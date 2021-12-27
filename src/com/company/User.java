package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends IUser {
    public User() {
        super();
    }

    private String phoneNum;
    private String email;
    private Offer offer;
    private boolean verified;
    public String getPhoneNum() {
        return phoneNum;
    }

    public User(String userName, String password, String phoneNum, String email, Offer offer) {
        super(userName, password);
        this.phoneNum = phoneNum;
        this.email = email;
        this.offer = offer;

    }

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Ride requestRide(IArea s, IArea d) {
        Ride ride = new Ride(s, d);
        ride.checkSourceArea(s);
        return ride;
    }

    public Offer chooseOffer(Ride ride) {
        System.out.println("Choose one of these offers");

        for (int i = 0; i < ride.getOffers().size(); i++) {
            System.out.println((int)(i + 1) + ":" );
            ride.getOffers().get(i).to_String();
        }
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
        //this.setOffer(offers.get(choise - 1));

        LocalTime time = LocalTime.now();
        String Time = time.toString();
        Event event = new AcceptanceEvent(this , Time);
        ride.addEvent(event);

        return ride.getOffers().get(choise-1);
    }

    @Override
    public String toString() {
        return "User(username= "+userName+" ,"+"email= " + email + ", offer=" + offer + ", phoneNum=" + phoneNum + ")"+"\n";
    }


}