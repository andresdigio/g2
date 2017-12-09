package com.model;

/**
 * Created by martina on 12/7/17.
 */
public class Location {
    private String address, city, country, province, zipCode;

    public Location(String address, String city, String country, String province, String zipCode) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.province = province;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getZipCode() {
        return zipCode;
    }
}
