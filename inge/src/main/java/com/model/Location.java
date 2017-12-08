package com.model;

/**
 * Created by martina on 12/7/17.
 */
public class Location {
    private String street, city, country, province;
    private Integer zipCode;

    public Location(String street, String city, String country, String province, Integer zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.province = province;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
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

    public Integer getZipCode() {
        return zipCode;
    }
}
