package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
import java.util.List;

public class Event {
     private List<String> friends;
     private String name;
     public Event(String n, List<> bobs) {
         this.name = n;
         this.friends = bobs;
     }

     public String getName() {
         return this.name;
     }

     public List<String> getFriends() {
         return this.friends;
     }

     public void setName(String n) {
         this.name = n;
     }
     public void addFriend(String friend) {
         friends.add(friend);
     }
     public void deleteFriend(String friend) {
         friends.remove(friend);
     }

}
