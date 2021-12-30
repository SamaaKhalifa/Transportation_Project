package com.company;

public class FivePresentDiscount extends Discount{
    IOffer iOffer;

    public FivePresentDiscount(IOffer ioffer) {
        super(ioffer);
        this.iOffer = ioffer;
    }

    public double calculatePrice() {
        //iOffer.setPrice(iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice()));
        return iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice());
    }
}