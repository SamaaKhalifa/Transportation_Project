package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User extends IUser {
    public User() {
        super();
    }

    private String phoneNum;
    private String email;
    private Offer offer;
    private boolean verified;
    private String birthDate;
    private ArrayList<Offer>savedOffers= new ArrayList<>();

    public IRide getChosenRide() {
        return chosenRide;
    }

    public void setChosenRide(Ride chosenRide) {
        this.chosenRide = chosenRide;
    }

    private Ride chosenRide;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Ride requestRide(IArea s, IArea d) {
        Ride ride = new Ride(s, d);
        ride.checkSourceArea(s);
        LocalDate date=LocalDate.now();
        ride.setDate(date.toString());
        return ride;
    }

    public Offer chooseOffer(Ride ride) {
        System.out.println("Choose one of these offers");

        for (int i = 0; i < ride.getOffers().size(); i++) {
            System.out.println((int)(i + 1) + ":" );
            (ride.getOffers().get(i)).to_String();

        }

        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
        this.setOffer(ride.getOffers().get(choise - 1));
        this.setChosenRide(ride);

        calcprice();
        System.out.println("Price after discount : " + offer.getUserPrice());

        Event event1 = new AcceptanceEvent(this );

        ride.addEvent(event1);

        offer.getDriver().startRide(this);
        savedOffers.add(offer);

        return ride.getOffers().get(choise-1);
    }
    public void calcprice(){
        IOffer offer = new Discount(this.offer);
        if (chosenRide.getDestenation().getAdminDiscount()==true){
              offer= new TenPresentDiscount(this.offer);
        }
        if (birthDate==chosenRide.getDate()){
            offer= new TenPresentDiscount(this.offer);
        }
        /*if (chosenRide.getPassNum()==2){
            offer = new FivePresentDiscount(offer);

        }*/
        if (savedOffers.size()==0){
            offer= new TenPresentDiscount(this.offer);
        }
        if (chosenRide.checkHoliday()==true){
            offer = new FivePresentDiscount(offer);
        }
        //System.out.println(offer.calculatePrice());
        // offer = new FivePresentDiscount(offer);
        //System.out.println(offer.calculatePrice());
        this.offer.setUserPrice(offer.calculatePrice());
        System.out.println("-----------------user--------------------");
        System.out.println(this.offer.getUserPrice());
        System.out.println("------------------driver-------------------");
        System.out.println(this.offer.getdriverPrice());
    }
    @Override
    public String toString() {
        return "User(username= "+userName+" ,"+"email= " + email + ", offer=" + offer + ", phoneNum=" + phoneNum + ")"+"\n";
    }


}