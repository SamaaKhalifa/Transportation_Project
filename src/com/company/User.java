package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User extends IUser {
    public User() {
        super();
    }

    private String phoneNum;
    private String email;
    private IOffer offer;
    private boolean verified;
    private String birthDate;
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

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

    public IOffer getOffer() {
        return offer;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }

    public Ride requestRide(IArea s, IArea d,int noOfPass) {
        Ride ride = new Ride(s, d);
        ride.checkSourceArea(s);
        RideRequest nwRequest=new RideRequest();
        LocalDate date=LocalDate.now();
        nwRequest.setDate(date.toString());
        ride.addRequest(nwRequest);
        return ride;
    }

    public Offer chooseOffer(Ride ride) {
        System.out.println("Choose one of these offers");

        for (int i = 0; i < ride.getOffers().size(); i++) {
            System.out.println((i + 1) + ":" );
            //((Offer)ride.getOffers().get(i)).to_String();
            System.out.println("Price: "+ride.getOffers().get(i).calculatePrice());
            System.out.println("Driver: "+((Offer)ride.getOffers().get(i)).getDriver());

        }
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();

        this.setOffer(ride.getOffers().get(choise - 1));

        LocalTime time = LocalTime.now();
        String Time = time.toString();
        Event event1 = new AcceptanceEvent(this , Time);
        ride.addEvent(event1);
        LocalTime time2;
        if(time.getMinute() + 30 > 60)
             time2 = LocalTime.of(time.getHour()+1, time.getMinute(), time.getSecond());
        else
            time2 = LocalTime.of(time.getHour(), time.getMinute()+30, time.getSecond());

        String Time2 = time2.toString();
        Event event2 = new locationEvent(this , ((Offer)offer).getDriver(), Time2,"Captain arrived to user location");
        ride.addEvent(event2);

        return (Offer) ride.getOffers().get(choise-1);
    }

    @Override
    public String toString() {
        return "User(username= "+userName+" ,"+"email= " + email + ", offer=" + offer + ", phoneNum=" + phoneNum + ")"+"\n";
    }


}