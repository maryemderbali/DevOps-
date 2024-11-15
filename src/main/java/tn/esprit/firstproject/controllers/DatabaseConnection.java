package tn.esprit.firstproject.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DESKTOP-6AQ3P66\\SQLEXPRESS;databaseName=yourDatabaseName;integratedSecurity=true;loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
