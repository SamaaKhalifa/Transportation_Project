package com.company;

public class UserRegister extends Registration{
    @Override
    public void Register(IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            System.out.println("This data is not valid");
        } else {
            obj.save(iuser);
            iuser.verified = true;
        }
    }

    @Override
    public void login(IUser iuser) {
        IUser result;

        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());

        if(iuser.verified == true) {
            if (result == null) {
                System.out.println("This data is not valid");
            } else {
                System.out.println("You logged in the System successfully");
            }
        }
        else{
            System.out.println("You should register before log in.");
        }
    }
}