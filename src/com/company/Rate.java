package com.company;

import java.util.ArrayList;

public class Rate {
     private  ArrayList<Integer>rates=new ArrayList<>();
     public double averageRating(){
          double sum=0.0;
          for (int i=0;i<rates.size();i++){
               sum+=rates.indexOf(i);
          }
          return sum/rates.size();

     }
     public void addRate(int rate){
          rates.add(rate);
     }
     public void getRates(){
          for (int i = 0; i < rates.size(); i++) {
               System.out.println("rate of user " + i + 1 + ": " + rates.get(i));
          }
     }


}
