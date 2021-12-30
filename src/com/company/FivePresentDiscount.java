package com.company;

public class FivePresentDiscount extends Discount{

    public FivePresentDiscount(IOffer ioffer) {
        super(ioffer);
    }
    @Override
    public double calculatePrice() {
        iOffer.calculatePrice();
        getDis();
        //iOffer.setPrice(iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice()));
        return iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice());
    }
    public void getDis(){
        System.out.println(iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice()));
    }
}