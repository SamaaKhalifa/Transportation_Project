package com.company;

public class SourceEvent implements Event{
    private User user;

    private Driver driver;

    private String name = "Captain arrived to user location ";

    private String time;

    public SourceEvent(User user , Driver driver , String time)
    {
        this.time = time;
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