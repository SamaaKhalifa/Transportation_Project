package com.company;

import java.util.ArrayList;

public class admin extends IUser {
    ISaving saving = new arraySaving();

    public void suspend(IUser user) {
        for (IUser iuser : saving.retrieveUsers()) {
            if (iuser.equals(user)) {
                if(iuser instanceof User) ((User)iuser).setVerified(false);
                if(iuser instanceof Driver) ((Driver)iuser).setVerified(false);
                saving.retrievePended().add(user);
                saving.retrieveUsers().remove(user);
            }
        }
    }

    public void verify(Driver Driv) {
        for (IUser driver : saving.retrievePended()) {
            if (driver.equals(Driv) && driver instanceof Driver) {
                ((Driver) driver).setVerified(true);
                saving.retrievePended().remove(driver);
                saving.retrieveUsers().add(driver);
            }
        }
    }

    ;

    public ArrayList<IUser> listPendingRegistration() {
        return saving.retrievePended();
    }

    public void loginAdmin(IUser iuser) {
        IUser result;
        result = saving.searchAdmin(iuser.getUserName(), iuser.getPassword());

        if (result == null) {
            System.out.println("You are not an admin!");
        } else {
            System.out.println("You logged in successfully.");
        }
    }


}
