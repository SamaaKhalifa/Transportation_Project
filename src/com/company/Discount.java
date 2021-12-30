package com.company;

public abstract class Discount implements IOffer{
    protected IOffer iOffer;

    public Discount(IOffer ioffer)
    {
        this.iOffer = ioffer;
    }

    public double calculatePrice() {
        return iOffer.calculatePrice();
    }
}