package com.model;

public class User {
    private String name, lastName;
    private String password; //TODO 1 Hay que cambiarlo para guardar password encriptada
    private Location loc;
    private Integer phoneNum, workNum;

    public String getName() {
        return name;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public Integer getWorkNum() {
        return workNum;
    }

    public Location getLoc() {
        return loc;
    }

    public String getLastName() {
        return lastName;
    }

    //TODO 2 este hay que modificarlo
    public String getPassword() {
        return password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO 3 este hay que modificarlo
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setWorkNum(Integer workNum) {
        this.workNum = workNum;
    }
}
