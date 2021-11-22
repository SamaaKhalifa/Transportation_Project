package com.company;

public class AdminRegesteration extends  Registration {
     @Override
    public void login(IUser iuser) {
        IUser result;

        result = obj.searchAdmin(iuser.getUserName(), iuser.getPassword());

        if (result == null) {
            System.out.println("You are not an admin");
        } else {
            iuser.verified = true;
            System.out.println("You logged in the System successfully");
        }
    }
}