package com.company;

import java.util.ArrayList;

public interface IDriver {
    double getAvgRating();
    void rateMe(int rate);
    void makeOffer(Ride ride);
    void AddNewFavArea(Area area);
    ArrayList<Ride> listRides();
    void addRide(Ride ride);
    ArrayList<Area> getFavAreas();
}
