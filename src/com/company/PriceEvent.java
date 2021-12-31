package com.company;

import java.time.LocalTime;

public class PriceEvent implements Event{
    private Offer offer ;

    private String name = " Captain put a price to the ride";

    private String time;

    public PriceEvent(Offer offer )
    {
        LocalTime time = LocalTime.now();
        String Time = time.toString();
        this.time = Time;
        this.offer = offer;
    }
    @Override
    public void printEvent() {
        System.out.println("Name : " + name+
                        "  Time : " + time +
                        "  CaptainName : "+ offer.getDriver().getUserName()+
                        "  driverPrice : " + offer.getdriverPrice()
                //+" UserPrice : "+offer.getUserPrice()
        );
    }
}
