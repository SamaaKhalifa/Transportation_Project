package com.company;

import java.util.ArrayList;

public class Ride implements IRide {

    private IArea source;
    private IArea Destenation ;
    private boolean start,end;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    private ArrayList <Event> events = new ArrayList<>();

    private ArrayList<Offer> offers=new ArrayList<>();

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

    public void addEvent(Event event)
    {
        events.add(event);
    }

    public void removeEvent(Event event)
    {
        events.remove(event);
    }

    public Ride(IArea source, IArea Destenation) {
        this.source = source;
        this.Destenation = Destenation;
    }

    public IArea getSource() {
        return source;
    }

    public void setSource(IArea source) {
        this.source = source;
    }

    public IArea getDestenation() {
        return Destenation;
    }

    public void setDestenation(IArea Destenation) {
        this.Destenation = Destenation;
    }

    // may we put this fun in the constractor of the ride
    public void checkSourceArea (IArea area){
        if(area instanceof Area){
            area.notifyDriver(this);
        }
    }

    @Override
    public void addOffer(Offer newOffer) {
        offers.add(newOffer);
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        return "Ride [source=\n" + source + "\nDestenation=\n" + Destenation +"]";
    }
}