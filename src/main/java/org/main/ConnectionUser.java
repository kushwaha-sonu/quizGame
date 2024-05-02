package org.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUser {
    private  Connection connection;

    // Method to initialize connection
    public Connection initializeConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/quiz";
            String password = "#Sk9110@$";
            String username = "root";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                return connection;
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }

        return null;
    }

    // Method to close connection
    public  void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

}
