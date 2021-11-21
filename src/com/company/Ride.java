package com.company;

public class Ride implements IRide {
    private IArea source;
    private IArea dest ;

    public Ride(IArea source, IArea dest) {
        this.source = source;
        this.dest = dest;
    }

    public IArea getSource() {
        return source;
    }




    public void setSource(IArea source) {
        this.source = source;
    }


    public IArea getDest() {
        return dest;
    }


    public void setDest(IArea dest) {
        this.dest = dest;
    }


    public  Offer checkSourceArea (IArea area){
        if(area instanceof Area){
            area.notifyDriver()
        }
      

    }

    
}
