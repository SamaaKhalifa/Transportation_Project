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
    public boolean login(IUser iuser) {

        IUser result;
        boolean ans=false;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (iuser instanceof Driver) {


            if (((Driver) iuser).getVerified() == true) {
                ans=true;
                System.out.println("You logged in successfully.");
            } else {
                ans=false;
                System.out.println("You are not verified yet!");
            }
        }

        else{
            System.out.println("you are not driver");
            ans=false;
        }
        return ans;
    }
}