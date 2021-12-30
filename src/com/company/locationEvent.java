package com.company;

public class locationEvent implements Event {
    private User user;
    private Driver driver;
    private String name;
    private String time;

    public locationEvent(User user , Driver driver , String time,String name)
    {
        this.name=name;
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
