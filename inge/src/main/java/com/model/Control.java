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
            ResultSet rs = stmt.executeQuery("SELECT username , pass FROM business_user WHERE username = '" +  username + "';");

            while (rs.next()) {
                if(rs.getString("pass").equals(password)) {
                    System.out.println("Correct password! Welcome business client.");
                    return 1;
                }
            }

            rs = stmt.executeQuery("SELECT username , pass FROM client_user WHERE username = '" + username+ "';");

            while (rs.next()) {
                if(rs.getString("pass").equals(password)) {
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

    public static int signUpCompany(String name, String password, Location location, String phoneNumber) {

        return 1;
    }

    public static int signUpClient(String username, String password, Location location, String phoneNumber) {
        return 1;
    }

    public static int makeMeeting(String productType, float price, String username, String companyName) {
        return 1;
    }
}
