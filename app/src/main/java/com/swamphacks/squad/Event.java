package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;

public class Event {
     private String name;
     private EventEntry entry;

     public Event() {

     }

     public Event(User u, String n, List<String> bobs) {
         this.name = n;
         this.entry = new EventEntry(n, bobs);
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
         entry.addFriend(friend);
     }
     public void deleteFriend(String friend) {
         entry.deleteFriend(friend);
     }
     public void setOwner(String n) {
         entry.setOwner(n);
     }
     public String getOwner() {
         return entry.getOwner();
     }
}
