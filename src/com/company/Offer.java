package com.company;

public class Offer {
    private double price ;
    private Driver driver ;
    public void setDriver (Driver driver) {
        this.driver=driver;
    }
    public void setPrice (double price ) {
            this.price=price;
    }
    public void to_String(){
        System.out.println("Price: "+price+"\n"+"Driver info: "+driver);
    }
    public Driver getDriver() {
        return driver;
    }
}
