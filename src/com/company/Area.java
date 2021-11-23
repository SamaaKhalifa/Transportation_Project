package com.company;

import java.sql.Driver;
import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyDriver(Ride ride) {
        ArrayList<Offer>offers =new ArrayList<>();
        for (int i = 0; i < drivers.size(); i++) {
           drivers.get(i).addRide(ride);
        }


    }

    @Override
    public void addDriver(com.company.Driver driver) {
        drivers.add(driver);

    }
    @Override
    public void removeDriver(com.company.Driver driver) {
        drivers.remove(driver);
        //drivers.remove(new Driver (driver));

    }

    @Override
    public String toString() {
        return "Area [drivers=" + drivers + ", name=" + name + "]";
    }


   

    

   
}
