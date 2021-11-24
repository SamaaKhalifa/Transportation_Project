package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends IUser implements IDriver {

    private String drivingLicense;
    private String nationalId;
    private ArrayList<Area> favoriteAreas = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private Rate rate;
    private double AvgRate;
    private String phoneNum;
    private String email;
    private boolean verified;
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

    public void setEmail(String email) {
        this.email = email;

    };
    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalId() {
        return nationalId;
    }

    public double getAvgRate() {
        return AvgRate;
    }

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
    public void rateMe(int rate) {
        this.rate.addRate(rate);
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
    public void makeOffer(Ride ride) {
        Offer newOffer = new Offer();
        newOffer.setDriver(this);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Price you want in this offer");

        double price = input.nextDouble();
        newOffer.setPrice(price);
        ride.addOffer(newOffer);
    }

    @Override
    public void AddNewFavArea(Area area) {
        area.addDriver(this);
        favoriteAreas.add(area);
    }

    @Override
    public ArrayList<Area> getFavAreas() {
       /* for (int i = 0; i < favoriteAreas.size(); i++) {
            System.out.println("Area " + i + 1 + ": " + favoriteAreas.get(i));
        }*/
        return favoriteAreas;

    }

    @Override
    public ArrayList<Ride> listRides() {
        /*for (int i = 0; i < rides.size(); i++) {
            System.out.println("ride " + i + 1 + ": " + rides.get(i));
        }*/
        return rides;

    }

    public String toString() {
        return "Driver( username "+userName+ "  ,email "+email+"  ,Driving License" + getDrivingLicense() + "  ,National ID" + getNationalId()+")"+"\n";
    }
    @Override
    public void addRide(Ride ride){
        rides.add(ride);
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public Rate getRate() {
        return rate;
    }
}
