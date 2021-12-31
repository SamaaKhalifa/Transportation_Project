package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class Ride implements IRide {

    private IArea source;
    private IArea Destenation ;
    ArrayList<RideRequest> requests;
    private ArrayList <Event> events = new ArrayList<>();


    public ArrayList<Event> getEvents() {
        return events;
    }
    public void addRequest(RideRequest nwRequest){
            requests.add(nwRequest);
    }
    public boolean checkHoliday(){
        LocalDate date= LocalDate.now();
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY){
            return true;
        }
        return false;
    }

    public ArrayList<RideRequest> getRequests() {
        return requests;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
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

    public Area getSource() {
        return (Area) source;
    }

    public void setSource(IArea source) {
        this.source = source;
    }

    public Area getDestenation() {
        return(Area) Destenation;
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
    public String toString() {
        return "Ride [source=\n" + source+ "\nDestenation=\n" + Destenation +"]";
    }
}