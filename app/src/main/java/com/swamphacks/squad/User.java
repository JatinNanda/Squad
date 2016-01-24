package com.swamphacks.squad;

/**
 * Created by manavdutta1 on 1/24/16.
 */
public class User {
    private String username;
    private String code;
    private String token;
    public User(String uName, String token) {
        this.username = uName;
        this.token = token;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getUsername() {
        return this.username;
    }
    public String getCode() { return this.code; }
}
