package com.company;

public class UserRegister extends Registration {
    @Override
    public void Register(IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            System.out.println("This account already exist , Try to login!");
        } else {
            obj.saveUser(iuser);
            // iuser.verified = true;
            ((User) iuser).setVerified(true);
            System.out.println("you registered successfully!, Welcome!!");
        }
    }

    @Override
    public void login(IUser iuser) {

        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (iuser instanceof User) {
            if (result == null) {
                System.out.println("You should register before log in.");
            } else {
                if (((User) iuser).getVerified() == true) {
                    System.out.println("You logged in successfully.");
                } else {
                    System.out.println("You are not verified yet!");
                }
            }
        }
    }
}