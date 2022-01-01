package com.company;

import java.util.ArrayList;

public class arraySaving implements ISaving {

    static ArrayList<IUser> iusers = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();
    static ArrayList<IUser> pending = new ArrayList<>();
    static ArrayList<IUser> admins = new ArrayList<>();

    @Override
    public void saveUser(IUser user) {
        if (!iusers.contains(user))
            iusers.add(user);

    }

    ;

    @Override
    // add admin internally.
    public void addAdmin(IUser admin) {
        if (!admins.contains(admin))
            admins.add(admin);
    }

    @Override
    public void savePended(IUser pended) {
        if (!pending.contains(pended))
            pending.add(pended);
    }

    @Override
    public void save(Area area) {
        if (!areas.contains(area))
            areas.add(area);
    }

    @Override
    public void save(Ride ride) {
        if (!rides.contains(ride))
            rides.add(ride);
        this.save((Area) ride.getSource());
        this.save((Area) ride.getDestenation());
    }

    @Override
    public ArrayList<IUser> retrieveUsers() {
        return iusers;
    }

    @Override
    public ArrayList<IUser> retrievePended() {
        return pending;
    }

    @Override
    public ArrayList<Area> retrieveArea() {
        return areas;
    }

    @Override
    public ArrayList<Ride> retrieveRide() {
        return rides;
    }

    @Override
    public IUser searchIUser(String userName, String Password) {
        for (IUser user : iusers) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    @Override
    public IRide searchRide(Area source, Area destination) {
        for (IRide ride : rides) {
            if (source.equals(((Ride)ride).getSource()) && destination.equals(((Ride)ride).getDestenation())) {
                return ride;
            }
        }
        IRide ride = new Ride(source,destination);
        save((Ride) ride);
        return ride;
    }
    @Override
    public IArea searchArea(String name) {
        for (IArea area : this.retrieveArea()) {
            if (((Area) area).getName().equals(name)) {
                return area;
            }
        }
        IArea nwArea = new Area();
        nwArea.setName(name);
        save((Area) nwArea);
        return nwArea;
    }

    @Override
    public IUser searchAdmin(String userName, String Password) {
        for (IUser user : admins) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}