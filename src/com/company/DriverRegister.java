package com.company;

public class DriverRegister extends Registration{
    @Override
    public void Register( IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            System.out.println("This data is not valid");
        } else {
            obj.save(iuser);
        }
    }

    @Override
    public void login(IUser iuser) {
        IUser result;

        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());

        if(iuser.verified == true) {
            if (result == null) {
                System.out.println("This data is not valid.");
            } else {
                System.out.println("You logged in the System successfully.");
            }
        }
        else{
            System.out.println("You are in the waiting list.");
        }
    }
}
