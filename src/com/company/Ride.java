package com.company;

import java.util.ArrayList;

public class Ride implements IRide {

    private IArea source;
    private IArea Destenation ;
    ArrayList<RideRequest> requests;

        public ArrayList<Event> getEvents() {
        return events;
    }
    public void addRequest(RideRequest nwRequest){
            requests.add(nwRequest);
    }
    public ArrayList<RideRequest> getRequests() {
        return requests;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    private ArrayList <Event> events = new ArrayList<>();

    private ArrayList<IOffer> offers=new ArrayList<>();


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
    public void addOffer(IOffer newOffer) {
        offers.add(newOffer);
    }

    public ArrayList<IOffer> getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        return "Ride [source=\n" + source+ "\nDestenation=\n" + Destenation +"]";
    }
}