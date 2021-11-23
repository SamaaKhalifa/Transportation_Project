package com.company;

public class UserRegister extends Registration{
    @Override
    public void Register(IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            System.out.println("This account already exist , Try to login!");
        } else {
            obj.saveUser(iuser);
            //iuser.verified = true;
            ((User)iuser).setVerified(true);
            System.out.println("you registered successfully!, Welcome!!");
        }
    }

    @Override
    public void login(IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if(iuser instanceof User){
        if(((User)iuser).getVerified() == true) {
            if (result == null) {
                System.out.println("Either userName or Password is incorrect!");
            } else {
                System.out.println("You logged in successfully.");
            }
        }
        else{
            System.out.println("You should register before log in.");
        }
    }
    }
}