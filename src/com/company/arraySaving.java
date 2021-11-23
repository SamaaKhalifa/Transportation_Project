package com.company;

import java.util.ArrayList;

public class arraySaving implements ISaving {

    static ArrayList<IUser> iusers = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();
    static ArrayList<IUser> pending = new ArrayList<>();
    static ArrayList<IUser> admins = new ArrayList<>();

    public void saveUser(IUser user) {
        if (!iusers.contains(user))
            iusers.add(user);

    }

    ;

    // add admin internally.
    public void addAdmin(IUser admin) {
        if (!admins.contains(admin))
            admins.add(admin);
    }

    public void savePended(IUser pended) {
        if (!pending.contains(pended))
            pending.add(pended);
    }

    public void save(Area area) {
        if (!areas.contains(area))
            areas.add(area);
    }

    public void save(Ride ride) {
        if (!rides.contains(ride))
            rides.add(ride);
        this.save((Area) ride.getSource());
        this.save((Area) ride.getDestenation());
    }

    public ArrayList<IUser> retrieveUsers() {
        return iusers;
    }

    public ArrayList<IUser> retrievePended() {
        return pending;
    }

    public ArrayList<Area> retrieveArea() {
        return areas;
    }

    
    public ArrayList<Ride> retrieveRide() {
        return rides;
    }

    public IUser searchIUser(String userName, String Password) {
        for (IUser user : iusers) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public IUser searchAdmin(String userName, String Password) {
        for (IUser user : admins) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    
}
