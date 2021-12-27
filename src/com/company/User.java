package com.company;

import java.util.Scanner;

public class User {
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

    public Offer requestRide(IArea source, IArea dest) {
        source = new Area();
        dest = new Area();
        Ride ride = new Ride(source, dest);

    }

    public Offer chooseOffer(ArrayList<Offer> offers) {
        System.out.println("Choose one of these offers");
        int i;
        for (i = 0; i < offers.length; i++) {
            System.out.println(i + 1 + ":" + offers.indexOf(i));
        }
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
<<<<<<< Updated upstream
        this.setOffer(offers.git(i - 1));
=======
         return offers.get(choise - 1);
>>>>>>> Stashed changes

    }

    @Override
    public String toString() {
        return "User [email=" + email + ", offer=" + offer + ", phoneNum=" + phoneNum + "]";
    }

    
}