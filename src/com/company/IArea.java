package com.company;

import java.sql.Driver;
import java.util.ArrayList;

interface IArea {
    void notifyDriver(Ride ride);
    void addDriver(com.company.Driver driver);
    void removeDriver(com.company.Driver driver);
    void setName(String name);
}
