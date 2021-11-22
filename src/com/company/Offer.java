package com.company;

public class Offer {
    private Ride ride;
    private double price ;
    private Driver driver ;
    public void setDriver (Driver driver) {
        this.driver=driver;
    }
    public void setPrice (double price ) {
            this.price=price;
    }
    public void setRide( Ride ride){
           this.ride=ride;
    }

    public void to_String(){
        System.out.println("Price: "+price+"\n"+"Ride info: "+ride+"\n"+"Driver info: "+driver);
    }

    }
