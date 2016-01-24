package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
public class User {
    private String username;
    private Event event;
    public User(String uName) {
        this.username = uName;
    }
    public String getUsername() {
        return this.username;
    }
}
