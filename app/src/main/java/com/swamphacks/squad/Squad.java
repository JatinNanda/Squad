package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
public class Squad {
    private String name;
    private String ownerName;
    private String[] usernames;
    private Event[] events;
    private int numUsers;
    private int numEvents;
    private String code;
    public Squad(String code, String name, String ownerName) {
        this.ownerName = ownerName;
        numUsers = 1;
        numEvents = 0;
        usernames = new String[100];
        events = new Event[100];
        name = this.name; //defining
        code = this.code; //defining
    }

    public String[] getUserNames() {
        return usernames;
    }
    public void addUser(String s) {
        if(numUsers < 100) {
            usernames[numUsers++] = s;
        }

    }

    public void addEvent(Event e) {
        if(numEvents < 100) {
            events[numEvents++] = e;
        }
    }


    public String getName() {
        return this.name;
    }
    public String getOwnerName() {
        return ownerName;
    }
}
