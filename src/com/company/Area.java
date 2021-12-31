package com.company;

import java.sql.Driver;
import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;
    private boolean hasAdminDiscount;

    public boolean getAdminDiscount() {
        return hasAdminDiscount;
    }

    public void setHasAdminDiscount(boolean hasAdminDiscount) {
        this.hasAdminDiscount = hasAdminDiscount;
    }

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
        if(!drivers.contains(driver)) drivers.add(driver);

    }
    @Override
    public void removeDriver(com.company.Driver driver) {
        drivers.remove(driver);
        //drivers.remove(new Driver (driver));

    }

    @Override
    public String toString() {
        return name ;
    }







}