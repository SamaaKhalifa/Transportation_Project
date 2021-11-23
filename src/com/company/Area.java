package com.company;

import java.sql.Driver;
import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;

    public ArrayList<Offer> notifyDriver(Ride ride) {
        ArrayList<Offer>offers =new ArrayList<>();
        for (int i = 0; i < drivers.size(); i++) {
           Offer offer= drivers.get(i).makeOffer(ride);//update
           offers.add(offer);

        }
         return offers;

    }

    public void addDriver(Driver driver) {
        drivers.add(driver);

    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
        //drivers.remove(new Driver (driver));

    }

    @Override
    public String toString() {
        return "Area [drivers=" + drivers + ", name=" + name + "]";
    }
    

}
