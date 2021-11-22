package com.company;

import java.sql.Driver;
import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;

    public void notifyDriver(Ride ride) {
        for (int i = 0; i < drivers.length(); i++) {
            drivers.indexOf(i).update();

        }
    }

    public void addDriver(Driver driver) {
        drivers.add( driver);

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
