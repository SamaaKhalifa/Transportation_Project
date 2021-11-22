package com.company;

import java.util.ArrayList;

public interface IDriver {
    double getAvgRating();
    void rateMe(int rate);
    Offer makeOffer(Ride ride);
    void AddNewFavArea(Area area);
    void getFavAreas();
    void listRides();
   /* void setDrivingLicense(String drivingLicense);
    void setNationalId();
    void setFavoriteAreas();
    void setRides();
    void setRate();
    void setVerified();
    String getDrivingLicense();
    String getNationalId();
    ArrayList<Area> getFavoriteAreas();
    ArrayList<Ride> getRides();
    Rate getRate();
    double getAvgRate();
    String getPhoneNum();
    boolean isVerified();
    String getEmail();
    */


}
