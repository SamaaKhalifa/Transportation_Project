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
    public boolean login(IUser iuser) {

        IUser result;
        boolean ans=false;
        System.out.println("in login");
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());

        if (iuser instanceof User) {

            if (((User) iuser).getVerified() == true) {
                System.out.println("You logged in successfully.");
                ans=true;
            } else {
                System.out.println("You are not verified yet!");
                ans=false;

            }
        }


        else{
            System.out.println("you are not user");
            ans=false;
        }
        return ans;
    }
}