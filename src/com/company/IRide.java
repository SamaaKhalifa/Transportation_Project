package com.company;

import java.util.ArrayList;

public interface IRide{
   void checkSourceArea (IArea area);
   void addOffer(Offer newOffer);
   ArrayList<Offer> getOffers();
}