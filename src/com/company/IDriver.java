package com.company;

import java.util.ArrayList;

public interface IDriver {
    double getAvgRating();
    void rateMe(int rate , User user);
    void makeOffer(Ride ride , double price);
    void AddNewFavArea(Area area);
    ArrayList<Ride> getRides();
    void addRide(Ride ride);
    void listRides();
    ArrayList<Area> getFavAreas();
}