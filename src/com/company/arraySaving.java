package com.company;

import java.util.ArrayList;

public class arraySaving implements ISaving{
    ArrayList<IUser> iusers;
     ArrayList <Area> areas;
     ArrayList <Ride> rides;
     ArrayList<IUser> pending;
     ArrayList <IUser> admins;

     public void save(IUser user){
            iusers.add(user);
    } ;
    public void save(IUser pended) {
            pending.add(pended);
    };
    public void save(Area area){
        areas.add(area);
    } ;
    public void save(Ride ride){
        rides.add(ride);
    };
    public ArrayList<IUser> retrieveUsers(){
        return iusers;
    }
    public ArrayList<IUser> retrievePended(){
        return pending;
    } ;
    public ArrayList<Area> retrieveArea(){
        return areas;
    } ;
    public ArrayList<Ride> retrieveRide(){
        return rides;
    } ;
    public IUser searchIUser(String userName, String Password){
        for (IUser user : iusers) {
            if(userName.equals(user.getUserName())&&Password.equals(user.getPassword())){
                return user;
            }
        }
        return null ;
    };
    public IUser searchAdmin(String userName, String Password){
        for (IUser user : admins) {
            if(userName.equals(user.getUserName())&&Password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    };
}
