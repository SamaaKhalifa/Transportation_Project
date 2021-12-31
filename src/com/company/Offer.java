package com.company;

public class Offer implements IOffer{
    private double driverPrice ;
    private double UserPrice ;
    private Driver driver ;

    public double getUserPrice() {
        return UserPrice;
    }

    public void setUserPrice(double userPrice) {
        UserPrice = userPrice;
    }


    public void setDriver (Driver driver) {
        this.driver=driver;
    }

    public void setdriverPrice (double price ) {
        this.driverPrice=price;
    }

    public double getdriverPrice() {
        return driverPrice;
    }

    public void to_String(){
        System.out.println("Price: "+driverPrice+ "  Price2: "+ UserPrice +"\n"+"Driver info: "+ driver);
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public double calculatePrice() {
        return driverPrice;
    }
}