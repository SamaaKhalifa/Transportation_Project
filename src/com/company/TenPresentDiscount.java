package com.company;

public class TenPresentDiscount extends Discount {

    IOffer iOffer;

    public TenPresentDiscount(IOffer ioffer) {
        super(ioffer);
        this.iOffer = ioffer;
    }

    public double calculatePrice() {
        //iOffer.setPrice(iOffer.calculatePrice() - (0.1 * iOffer.calculatePrice()));
        return iOffer.calculatePrice() - (0.1 * iOffer.calculatePrice());
    }
}