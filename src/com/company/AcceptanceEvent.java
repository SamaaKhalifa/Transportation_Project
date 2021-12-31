package com.company;

import java.time.LocalTime;

public class AcceptanceEvent implements Event {

    private User user ;

    private String name = "User accepts the captain price";

    private String time;

    public AcceptanceEvent(User user )
    {
        LocalTime time = LocalTime.now();
        String Time = time.toString();
        this.time = Time;
        this.user = user;
    }
    @Override
    public void printEvent() {
        System.out.println("Name : " + name+
                             "  Time : " + time +
                             "  UserName : "+ user.getUserName());
    }
}
