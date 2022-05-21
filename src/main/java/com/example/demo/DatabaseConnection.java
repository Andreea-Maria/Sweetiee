package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection()
    {
        String databaseName = "Accounts.db";
        String databaseUser = "admin";
        String databasePassword ="admin";
        String url = "jdbc:sqlite:identifier.sqlite" + databaseName;

        try{
            Class.forName("org.sqlite.JDBC");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }

        return databaseLink;
    }



}