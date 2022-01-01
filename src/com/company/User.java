package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User extends IUser {
    private String phoneNum;
    private String email;
    private Offer offer;
    private boolean verified;
    private RideRequest userRequest;
    private String birthDate;
    private Ride chosenRide;
    private ArrayList<Offer>savedOffers= new ArrayList<>();
    public User() {
        super();
    }
    public User(String userName, String password, String phoneNum, String email, Offer offer) {
        super(userName, password);
        this.phoneNum = phoneNum;
        this.email = email;
        this.offer = offer;

    }

    public IRide getChosenRide() {
        return chosenRide;
    }
    public void setChosenRide(Ride chosenRide) {
        this.chosenRide = chosenRide;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
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

    public RideRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(RideRequest userRequest) {
        this.userRequest = userRequest;
    }

    public Ride requestRide(IRide ride, int noOfPass) {
        RideRequest nwRequest=new RideRequest();
        if(userRequest==null){
            LocalDate date=LocalDate.now();
            nwRequest.setDate(date.toString());
            nwRequest.setNoOfPass(noOfPass);
            ((Ride)ride).addRequest(nwRequest);
            userRequest=nwRequest;
            ride.checkSourceArea(((Ride)ride).getSource());
        }
        System.out.println("after adding request:");
        System.out.println(((Ride)ride).getRequests());
        System.out.println("user req: "+userRequest);
        return (Ride)ride;
    }


    public Offer chooseOffer(Ride ride) {
        System.out.println("Choose one of these offers");

        for (int i = 0; i < userRequest.getOffers().size(); i++) {
            System.out.println((i + 1) + ":" );
            System.out.println("Price: "+userRequest.getOffers().get(i).calculatePrice());
            System.out.println("Driver: "+(userRequest.getOffers().get(i)).getDriver());

        }
        Scanner cs = new Scanner(System.in);
        int choise = cs.nextInt();
        this.setOffer(userRequest.getOffers().get(choise - 1));
        this.setChosenRide(ride);
        calcprice();
        System.out.println("Price after discount : " + offer.getUserPrice());
        Event event1 = new AcceptanceEvent(this );
        userRequest.addEvent(event1);
        offer.getDriver().startRide(this);
        savedOffers.add(offer);

        return userRequest.getOffers().get(choise-1);
    }
    public void calcprice(){
        IOffer offer = new Discount(this.offer);
        if (chosenRide.getDestenation().getAdminDiscount()==true){
              offer= new TenPresentDiscount(this.offer);
        }
        if (birthDate==userRequest.getDate()){
            offer= new TenPresentDiscount(this.offer);
        }
        if (userRequest.getNoOfPass()>=2){
            offer = new FivePresentDiscount(offer);
        }
        if (savedOffers.size()==0){
            offer= new TenPresentDiscount(this.offer);
        }
        if (chosenRide.checkHoliday()==true){
            offer = new FivePresentDiscount(offer);
        }
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