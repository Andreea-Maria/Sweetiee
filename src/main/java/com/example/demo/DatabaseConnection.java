package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection()
    {
        String databaseName = "demo_db";
        String databaseUser = "root";
        String databasePassword ="nuamparola20";
        String url = "jdbc:mysql://localhost:3306/demo_db";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }

        return databaseLink;
    }



}