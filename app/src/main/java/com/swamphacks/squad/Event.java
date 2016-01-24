package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;

public class Event {
     private List<String> friends;
     private String name;
     private EventEntry entry;

     public Event() {

     }

     public Event(String u, String n, List<> bobs) {
         this.name = n;
         this.entry = new EventEntry(u, bobs);
     }

     public String getName() {
         return this.name;
     }

     public List<String> getFriends() {
         return entry.getFriends();
     }

     public void setName(String n) {
         this.name = n;
     }
     public void addFriend(String friend) {
         entry.add(friend);
     }
     public void deleteFriend(String friend) {
         entry.remove(friend);
     }
     public void setOwner(String u) {
         entry.setOwner(u);
     }
     public void getOwner() {
         return entry.getOwner();
     }
}
