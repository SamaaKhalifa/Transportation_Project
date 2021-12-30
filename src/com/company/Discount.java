package com.company;

public abstract class Discount extends IOffer{
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