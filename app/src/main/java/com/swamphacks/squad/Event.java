package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;
import java.util.NoSuchElementException;

public class Event {
     private String name;
     private boolean isDone;
     private int price;

     public Event(String name) {
         this.name = name;
         this.isDone = false;
     }

     public Event(User u, String n, List<String> bobs) {
         this.name = n;
         this.isDone = false;
     }

     public String getName() {
         return this.name;
     }

     public boolean isDone() {
         return isDone;
     }

     public void setPrice(int cost) {
         this.price = cost;
     }

     public int getPrice() {
         if(isDone) {
             return price;
         } else {
             throw new NoSuchElementException("This event doesn't have a price yet.");
         }
     }


}
