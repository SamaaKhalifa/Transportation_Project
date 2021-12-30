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

        LocalTime time = LocalTime.now();
        LocalTime time1;
        if(time.getMinute() + 20 > 60)
            time1 = LocalTime.of(time.getHour() + 2 , time.getMinute(), time.getSecond());
        else
            time1 = LocalTime.of(time.getHour() + 1 , time.getMinute()+20 , time.getSecond());

        String Time = time1.toString();
        Event event = new locationEvent(user ,this , Time,"Captain arrived to user destination");
        choosenRide.addEvent(event);
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

        IOffer newOffer = new Offer();


        ((Offer) newOffer).setDriver(this);
        ((Offer) newOffer).setPrice(price);


        LocalTime time = LocalTime.now();
        String Time = time.toString();
        Event event = new PriceEvent((Offer) newOffer, Time);
        choosenRide.addEvent(event);

        newOffer = new TenPresentDiscount(newOffer);
        //System.out.println(((Offer)newOffer).getDriver().getUserName());
        System.out.println(newOffer.calculatePrice());
        System.out.println("********** 10 ****************");
        newOffer = new FivePresentDiscount(newOffer);
        System.out.println(newOffer.calculatePrice());
        System.out.println("//////////// 5 ////////////////////");

        ride.addOffer((IOffer)newOffer);
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
        return "Driver( username "+userName+" ,Avg rating "+getAvgRating()+ "  ,email "+email+"  ,Driving License" + getDrivingLicense() + "  ,National ID" + getNationalId()+")"+"\n";
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

    public void startRide(){
        choosenRide.setStart(true);
        choosenRide.setEnd(false);
    }

    public void endRide(){
        choosenRide.setStart(false);
        choosenRide.setEnd(true);
    }
}