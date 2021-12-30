package com.company;

public class Offer extends IOffer{

    private Driver driver ;

    public void setDriver (Driver driver) {
        this.driver=driver;
    }


    public void to_String(){
        System.out.println("Price before discount : "+ super.getPrice()+" Price after discount :"+  calculatePrice() + "  Driver info: " +driver.getUserName());
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public double calculatePrice() {

        return super.getPrice();
    }
}