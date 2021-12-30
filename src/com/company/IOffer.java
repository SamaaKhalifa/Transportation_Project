package com.company;

public abstract class IOffer {
    private double price ;

    abstract double calculatePrice ();

    public void setPrice (double price )
    {
        this.price=price;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return "IOffer { " +
                "price before =" + price +
                " price after = "+ calculatePrice()+
                " } ";
    }
}