package com.company;

import java.util.ArrayList;

public interface IDriver {
    double getAvgRating();
    void rateMe(int rate);
    Offer makeOffer(Ride ride);
    void AddNewFavArea(Area area);
    void getFavAreas();
    void listRides();
}
