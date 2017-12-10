package com.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class Singleton {

    public static Connection db;

    public static String hash(String password){
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
        /*
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = password.getBytes("UTF-8");
            return String.valueOf(md.digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";*/
    }

    public static String params(String u, String ... args){
        StringBuilder sb = new StringBuilder();
        sb.append("'" + u + "',");
        for(int i = 0; i < args.length; i++){
            sb.append("'" + args[i] + "'");

            if(i != args.length - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    public static String param(String a){
        return "'" + a + "'";
    }

    public static String params(String ... args){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            sb.append("'" + args[i] + "'");

            if(i != args.length - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    public static void init() {

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            db = DriverManager.getConnection("jdbc:postgresql://localhost:9999/u2017b-2?user=u2017b-2&password=passwordING1");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
