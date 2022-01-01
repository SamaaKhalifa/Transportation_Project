package com.company;

import java.time.LocalTime;
import java.util.ArrayList;

public class Driver extends IUser implements IDriver {

    private String drivingLicense;
    private String nationalId;
    private ArrayList<Area> favoriteAreas = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private Rate rate=new Rate();
    private String phoneNum;
    private String email;
    private boolean verified;
    private double balance;
    private boolean busy;
    private Ride choosenRide ;
    public final int MAX_PASS=4;
    private int noOfPass;
    ArrayList<RideRequest> driverRequsets=new ArrayList<>();
    public void addDriverReq(RideRequest nwRequest){
        driverRequsets.add(nwRequest);
    }
    public Driver() {
        super();
        noOfPass=0;
        balance=0;
    }
    public Driver(String userName, String password, String drivingLicense,
                  String nationalId, String phoneNum, String email) {
        super(userName, password);
        this.drivingLicense = drivingLicense;
        this.nationalId = nationalId;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    public ArrayList<RideRequest> getDriverRequsets() {
        return driverRequsets;
    }

    public int getNoOfPass() {
        return noOfPass;
    }

    public void setNoOfPass(int noOfPass) {
        this.noOfPass = noOfPass;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public double calcbalance(double price){
        balance+=price;
        return balance;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public boolean getVerified(){
        return verified;
    }
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) { this.email = email; };


    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setBusy(boolean b){ this.busy=true; }

    public boolean getBusy(){ return busy;}

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }

    @Override
    public double getAvgRating() {
        return rate.averageRating();
    }

    @Override
    public void rateMe(int rate , User user)
    {
        this.rate.addRate(rate);

        calcbalance(user.getOffer().getdriverPrice());
        endRide(user);


    }



    @Override
    public void makeOffer(Ride ride , double price) {
        choosenRide = ride;
        Offer newOffer = new Offer();
        for (RideRequest r:ride.getRequests()) {
            System.out.println("less noOfPass: "+r.getNoOfPass());
            if(MAX_PASS>=r.getNoOfPass()+noOfPass) {
                noOfPass+=r.getNoOfPass();
                 newOffer.setDriver(this);
                 newOffer.setdriverPrice(price);
                 System.out.println("newOffer data:"+newOffer);
                 newOffer.to_String();
                 r.addOffer(newOffer);
                System.out.println("request offer: "+r.getOffers().toString());
                Event event = new PriceEvent( newOffer);
                r.addEvent(event);
                 addDriverReq(r);
            }
        }
        System.out.println("Driver make offer ride req: ");
        System.out.println(ride.getRequests());

    }

    @Override
    public void AddNewFavArea(Area area) {
        area.addDriver(this);
        favoriteAreas.add(area);
    }
    @Override
    public ArrayList<Area> getFavAreas() {
        return favoriteAreas;
    }

    @Override
    public void listRides() {
        for (int i = 0; i < rides.size(); i++) {
            System.out.println("ride " + (i + 1) + ": " + rides.get(i));
        }
    }

    public String toString() {
        return "Driver( username "+userName+"balance "+balance+" ,Avg rating "+getAvgRating()+
                " ,email "+email+" ,Driving License" + getDrivingLicense() + " ,National ID" + getNationalId()+")"+"\n";
    }

    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    public Rate getRate() {
        return rate;
    }

    @Override
    public void addRide(Ride ride){
        rides.add(ride);
    }


    public void startRide(User user){
        user.getUserRequest().setStart(true);
        user.getUserRequest().setEnd(false);
        Event event = new locationEvent(user , this,"Captain arrived to user location");
        user.getUserRequest().addEvent(event);
    }

    public void endRide(User user){
        Event event = new locationEvent(user ,this ,"Captain arrived to user destination");
        user.getUserRequest().addEvent(event);
        user.getUserRequest().setStart(false);
        user.getUserRequest().setEnd(true);

    }
}

