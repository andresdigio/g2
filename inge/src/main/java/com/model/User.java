package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String username,email, name, lastName, phoneNum;
    private Location location;

    public User(String username, String name, String email, Location location, String phoneNum){
        this.username = username;
        this.name = name;
        this.email = email;
        this.location = location;
        this.phoneNum = phoneNum;
    }

    public User(ResultSet rs) throws SQLException {
        this.username = rs.getString("username");
        this.name = rs.getString("name");
        this.email = rs.getString("email");
        this.location = new Location(rs.getString("address"),rs.getString("department"), rs.getString("country"),rs.getString("province"),rs.getString("zip"));
        this.phoneNum = rs.getString("tel_number");
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
