package com.company;

public class PriceEvent implements Event{
    private Offer offer ;

    private String name = " Captain put a price to the ride";

    private String time;

    public PriceEvent(Offer offer , String time)
    {
        this.offer = offer;
        this.time = time;
    }
    @Override
    public void printEvent() {
        System.out.println("Name : " + name+
                "  Time : " + time +
                "  CaptainName : "+ (offer).getDriver().getUserName()+
                "  Price : " + ((Offer)offer).getPrice());
    }
}
