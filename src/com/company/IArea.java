package com.company;

interface IArea {
    void notifyDriver(Ride ride);
    void addDriver(com.company.Driver driver);
    void removeDriver(com.company.Driver driver);
    void setName(String name);
}