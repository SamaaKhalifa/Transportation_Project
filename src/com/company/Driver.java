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
    private Ride choosenRide ;
    public final int MAX_PASS=4;
    private int noOfPass;
    ArrayList<RideRequest> driverRequsets;
    public void addDriverReq(RideRequest nwRequest){
        driverRequsets.add(nwRequest);
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

    private boolean busy;
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

    public Driver() {
        super();
    }

    public Driver(String userName, String password, String drivingLicense, String nationalId, String phoneNum, String email) {
        super(userName, password);
        this.drivingLicense = drivingLicense;
        this.nationalId = nationalId;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public void makeOffer(Ride ride , double price) {
        this.choosenRide = ride;

        Offer newOffer = new Offer();

        newOffer.setDriver(this);
        newOffer.setdriverPrice(price);
        ride.addOffer(newOffer);


        ((Offer) newOffer).setDriver(this);
        ((Offer) newOffer).setPrice(price);
        ride.addOffer((Offer) newOffer);


        Event event = new PriceEvent( newOffer);
        choosenRide.addEvent(event);

      /*  newOffer = new TenPresentDiscount(newOffer);
        //System.out.println(((Offer)newOffer).getDriver().getUserName());
        System.out.println(newOffer.calculatePrice());
        System.out.println("********** 10 ****************");
        newOffer = new FivePresentDiscount(newOffer);
        System.out.println(newOffer.calculatePrice());
        System.out.println("//////////// 5 ////////////////////");*/


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
            System.out.println("ride " + (int)(i + 1) + ": " + rides.get(i));
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
        choosenRide.setStart(true);
        choosenRide.setEnd(false);
        Event event = new locationEvent(user , this,"Captain arrived to user location");
        choosenRide.addEvent(event);
    }

    public void endRide(User user){
        Event event = new locationEvent(user ,this ,"Captain arrived to user destination");
        choosenRide.addEvent(event);
        choosenRide.setStart(false);
        choosenRide.setEnd(true);

    }
}