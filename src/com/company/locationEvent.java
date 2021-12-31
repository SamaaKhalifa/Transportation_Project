package com.company;

import java.time.LocalTime;

public class locationEvent implements Event {
    private User user;
    private Driver driver;
    private String name;
    private String time;

    public locationEvent(User user , Driver driver ,String name)
    {
        this.name=name;
        LocalTime time = LocalTime.now();
        String Time = time.toString();
        this.time = Time;
        this.user = user;
        this.driver = driver;
    }

    @Override
    public void printEvent() {
        System.out.println("Name : " + name+
                "  Time : " + time +
                "  UserName : "+ user.getUserName()+
                "  CaptainName : " + driver.getUserName());

    }
}
