package com.company;

public class Discount implements IOffer{
   IOffer iOffer;

    public Discount(IOffer ioffer)
    {
        this.iOffer = ioffer;
    }

    @Override
    public double calculatePrice() {
        return iOffer.calculatePrice();
    }
}