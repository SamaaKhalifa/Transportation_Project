package com.company;

import java.util.ArrayList;

public class admin {
    ISaving saving=new arraySaving();

    public void suspend(IUser user) {
        for (IUser iuser : saving.retrieveUsers()) {
            if(iuser.equals(user)){
                iuser.setVerified(false);
                saving.retrievePended().add(user);
                saving.retrieveUsers().remove(user);
            }
        }
    }

    public void verify(Driver Driv){
        for (IUser driver : saving.retrievePended()) {
            if(driver.equals(Driv)&&driver instanceof Driver){
                ((Driver) driver).setVerified(true);
                saving.retrievePended().remove(driver);
                saving.retrieveUsers().add(driver);
            }
        }
    };
    public ArrayList<IUser> listPendingRegistration (){
        return saving.retrievePended();
    };




}
