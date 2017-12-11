package com.Control;

import com.model.Company;
import com.model.Login;
import com.model.Singleton;
import com.model.User;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.model.Singleton.hash;


public class Control {

    public static Login login(String username, String password){
        Statement stmt = null;
        password = hash(password);

        try {
            stmt = Singleton.db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM business_user WHERE username = '" +  username + "';");

            while (rs.next()) {
                if(rs.getString("pass").equals(password)) {
                    com.view.app.company = new Company(rs);
                    return Login.COMPANY;
                }
            }

            rs = stmt.executeQuery("SELECT * FROM client_user WHERE username = '" + username+ "';");

            while (rs.next()) {
                if(rs.getString("pass").equals(password)) {
                    com.view.app.user = new User(rs);
                    return Login.CLIENT;
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

        return Login.FAIL;
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

    private static boolean exists(String username){
        Statement stmt = null;

        try {
            stmt = Singleton.db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username FROM business_user WHERE username = '" +  username + "';");

            if(rs.next())
                return true;

            rs = stmt.executeQuery("SELECT username FROM client_user WHERE username = '" + username+ "';");

            if(rs.next())
                return true;

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
        return false;
    }


    public static int signUpCompany(String username, String ... args){
        if(exists(username))
            return 0;
        try {
            Singleton.db.createStatement().executeUpdate("INSERT INTO business_user (username, name, email, pass, country, province, department, address, zip,  tel_number, serviceRange, serviceType, serviceCharacteristics, serviceIncoterms, serviceIncludes,transportContainer, transportType, loadSize, loadType) VALUES (" + Singleton.params(username, args) + "); ");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    public static int signUpClient(String username, String ... args) {
        if(exists(username))
            return 0;
        try {
            Singleton.db.createStatement().executeUpdate("INSERT INTO client_user (username, pass, email, country, province, department, address, zip, tel_number, name) VALUES (" + Singleton.params(username,args) + "); ");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public static void updateCompany(String username,String ... args){
        try {
            Singleton.db.createStatement().executeUpdate("UPDATE business_user SET name="+Singleton.param(args[0])+",email="+Singleton.param(args[1])+",pass="+Singleton.param(args[2])+", country="+Singleton.param(args[3])+", province="+Singleton.param(args[4])+", department="+Singleton.param(args[5])+", address="+Singleton.param(args[6])+", zip="+Singleton.param(args[7])+",  tel_number="+Singleton.param(args[8])+", serviceRange="+Singleton.param(args[9])+", serviceType="+Singleton.param(args[10])+", serviceCharacteristics="+Singleton.param(args[11])+", serviceIncoterms="+Singleton.param(args[12])+", serviceIncludes="+Singleton.param(args[13])+",transportContainer="+Singleton.param(args[14])+", transportType="+Singleton.param(args[15])+", loadSize="+Singleton.param(args[16])+", loadType="+Singleton.param(args[17])+" WHERE username ="+Singleton.param(username)+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(String username,String ... args){
        try {
            Singleton.db.createStatement().executeUpdate("UPDATE client_user SET pass="+Singleton.param(args[0])+", email="+Singleton.param(args[1])+", country="+Singleton.param(args[2])+", province="+Singleton.param(args[3])+", department="+Singleton.param(args[4])+", address="+Singleton.param(args[5])+", zip="+Singleton.param(args[6])+", tel_number="+Singleton.param(args[7])+", name="+Singleton.param(args[8])+" WHERE username = " + Singleton.param(username) + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCompany(String username){
        try {
            Singleton.db.createStatement().executeUpdate("DELETE FROM business_user WHERE username = '" + username + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClient(String username){
        try {
            Singleton.db.createStatement().executeUpdate("DELETE FROM client_user WHERE username = '" + username + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int makeMeeting(String productType, float price, String username, String companyName) {
        return 1;
    }
}
