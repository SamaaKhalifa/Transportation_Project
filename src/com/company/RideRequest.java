package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

class RideRequest{
    private boolean start,end;
    private String date;
    private ArrayList<Offer> offers=new ArrayList<>();





    public void addOffer(Offer newOffer) {
        offers.add(newOffer);
    }
    public ArrayList<Offer> getOffers() {
        return offers;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        LocalDate date1= LocalDate.now();
        this.date = date1.toString();
    }


    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean getStart() {
        return start;
    }

    public boolean getEnd() {
        return end;
    }

}