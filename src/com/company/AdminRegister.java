package com.company;

public class AdminRegister extends  Registration {
    @Override

    public boolean login(IUser iuser) {
        IUser result;
        boolean ans=false;

        result = obj.searchAdmin(iuser.getUserName(), iuser.getPassword());

        if (result == null) {
            System.out.println("You are not an admin!");

            ans=false;
        } else {
            ans=true;
            System.out.println("You logged in successfully.");
        }
        return ans;

    }
}