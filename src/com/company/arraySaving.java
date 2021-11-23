package com.company;

import java.util.ArrayList;

public class arraySaving implements ISaving {
    static ArrayList<IUser> iusers=new ArrayList<>();
    static ArrayList<Area> areas=new ArrayList<>();
    static ArrayList<Ride> rides=new ArrayList<>();
    static ArrayList<IUser> pending=new ArrayList<>();
    static ArrayList<IUser> admins=new ArrayList<>();
    public void saveUser(IUser user) {
        iusers.add(user);
        System.out.println(iusers);
    }

    ;
    //add admin internally.
    public void addAdmin(IUser admin){
        admins.add(admin);
    }
    public void savePended(IUser pended) {
        pending.add(pended);
    }

    ;

    public void save(Area area) {
        areas.add(area);
    }

    ;

    public void save(Ride ride) {
        rides.add(ride);
    }

    ;

    public ArrayList<IUser> retrieveUsers() {
        return iusers;
    }

    public ArrayList<IUser> retrievePended() {
        return pending;
    }

    ;

    public ArrayList<Area> retrieveArea() {
        return areas;
    }

    ;

    public ArrayList<Ride> retrieveRide() {
        return rides;
    }

    ;

    public IUser searchIUser(String userName, String Password) {
        for (IUser user : iusers) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    ;

    public IUser searchAdmin(String userName, String Password) {
        for (IUser user : admins) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    ;
}
