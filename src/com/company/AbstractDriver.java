package com.company;

import java.util.ArrayList;

public abstract class AbstractDriver {
    protected String drivingLicense ;
    protected String  nationalId ;
    protected ArrayList<Area> favoriteAreas =new ArrayList<>();
    protected ArrayList<Ride> rides =new ArrayList<>();
    protected   Rate rate;
    protected  double AvgRate ;
    protected  String phoneNum ;
    protected  String email ;
    protected  boolean verified ;
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
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
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
    public abstract String toString();


}
