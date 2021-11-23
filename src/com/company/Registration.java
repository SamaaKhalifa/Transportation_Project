package com.company;

public abstract class Registration {
    public ISaving obj  = new arraySaving();

    public void Register(IUser iuser){
    }

    public abstract boolean login(IUser iuser);
}
