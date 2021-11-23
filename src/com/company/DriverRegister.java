package com.company;

public class DriverRegister extends Registration{
    @Override
    public void Register( IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            System.out.println("This account already exist , Try to login!");
        } else {
            obj.savePended(iuser);
        }
    }

    @Override
    public void login(IUser iuser) {

        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (iuser instanceof Driver) {
            if (result == null) {
                System.out.println("You should register before log in.");
            } else {
                if (((Driver) iuser).getVerified() == true) {
                    System.out.println("You logged in successfully.");
                } else {
                    System.out.println("You are not verified yet!");
                }
            }
        }
    }
}
