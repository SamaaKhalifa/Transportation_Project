package com.company;

public class Offer implements IOffer{
    private double price ;
    private Driver driver ;

    public void setDriver (Driver driver) {
        this.driver=driver;
    }

    public void setPrice (double price ) {
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void to_String(){
        System.out.println("Price: "+price+ "  Price: "+ calculatePrice() +"\n"+"Driver info: "+ driver);
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}