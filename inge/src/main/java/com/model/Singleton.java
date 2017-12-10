package com.model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class Singleton {

    public static Connection db;

    public static String params(String u, String ... args){
        StringBuilder sb = new StringBuilder();
        sb.append("'" + u + "',");
        for(int i = 0; i < args.length; i++){
            sb.append("'" + args[i] + "'");

            if(i != args.length - 1)
                sb.append(",");
        }
        System.out.println(sb.toString());
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
