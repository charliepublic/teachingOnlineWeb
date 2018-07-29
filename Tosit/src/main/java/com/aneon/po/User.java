package com.aneon.po;

public class User {

    private String username;
    private String name;

    public User(String username, String name, Identify identify) {
        this.username = username;
        this.name = name;
        this.identify = identify;
    }

    public User() {}

    public Identify getIdentify() {
        return identify;
    }

    public void setIdentify(Identify identify) {
        this.identify = identify;
    }

    private Identify identify;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
