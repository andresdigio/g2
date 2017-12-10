package com.model;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Control {

    public static int login(String username, String password){
        Statement stmt = null;

        try {
            stmt = Singleton.db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username , password FROM business_user WHERE username = '" +  username + "';");

            while (rs.next()) {
                if(rs.getString("password").equals(password)) {
                    System.out.println("Correct password! Welcome business client.");
                    return 1;
                }
            }

            rs = stmt.executeQuery("SELECT username , password FROM client_user WHERE username = '" + username+ "';");

            while (rs.next()) {
                if(rs.getString("password").equals(password)) {
                    System.out.println("Correct password! Welcome client.");
                    return 1;
                }
            }

        } catch (SQLException e ) {
            e.printStackTrace();

        } finally {

            if (stmt != null) {

                try {
                    stmt.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Incorrect password.");

        return 1;
    }

    public static List<Company> getCompanies(){
        List<Company> ret = new ArrayList<>();
        Statement stmt = null;

        try{
            stmt = Singleton.db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM business_user");
            while(rs.next()){
                ret.add(new Company(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    /*
    public static int signUpCompany(String username, String password,String name, String email, String container_type, String transport,String load_size,String load_type,String tel_number,String service_type,String service_description,String incoterms,String services_included,String country,String province,String department,String address,String zip) {
        Statement stmt = null;
        try {
            stmt = Singleton.db.createStatement();
            stmt.executeUpdate("INSERT INTO business_user (username, password, email, container_type, transport, load_size, load_type, country, province, department, address, zip, tel_number, service_type, service_description, incoterms, services_included, name) VALUES (" + Singleton.params(username, password, email, container_type, transport, load_size, load_type,country,province,department,address,zip,tel_number,service_type, service_description, incoterms, services_included, name) + "); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    */
    public static int signUpCompany(String ... args){
        if(args.length != 20) return 0;
        try {
            Singleton.db.createStatement().executeUpdate("INSERT INTO business_user (username, password, email, country, province, department, address, zip, tel_number, name, serviceRange, serviceType, serviceCharacteristics, serviceIncoterms, serviceIncludes, transportContainer, transportType, loadSize, loadType) VALUES (" + Singleton.params(args) + "); ");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    public static int signUpClient(String ... args) {
        if(args.length != 10) return 0;
        try {
            Singleton.db.createStatement().executeUpdate("INSERT INTO client_user (username, password, email, country, province, department, address, zip, tel_number, name) VALUES (" + Singleton.params(args) + "); ");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public static int makeMeeting(String productType, float price, String username, String companyName) {
        return 1;
    }
}
