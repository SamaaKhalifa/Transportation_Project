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

        if(iuser.verified == true) {
            if (result == null) {
                System.out.println("Either userName or Password is incorrect!");
            } else {
                System.out.println("You logged in successfully.");
            }
        }
        else{
            System.out.println("You are in the waiting list.");
        }
    }
}
