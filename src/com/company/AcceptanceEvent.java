package com.company;

public class AcceptanceEvent implements Event {

    private User user ;

    private String name = "User accepts the captain price";

    private String time;

    public AcceptanceEvent(User user , String time)
    {
        this.user = user;
        this.time = time;
    }
    @Override
    public void printEvent() {
        System.out.println("Name : " + name+
                             "  Time : " + time +
                             "  UserName : "+ user.getUserName());
    }
}
