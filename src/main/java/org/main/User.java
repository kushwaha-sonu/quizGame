package org.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private String email;
    private String name;

    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    ConnectionUser connectionUser = new ConnectionUser();


    public void addUserToDatabase( String email, String name, String password) {

        try {
            Connection connection=connectionUser.initializeConnection();
            String query = "INSERT INTO Users ( user_name, user_email, user_password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " User Added Successfully");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
    }


    public boolean getUserDataByEmail(String email) {
        try {
            Connection  connection= connectionUser.initializeConnection();
            String query = "SELECT * FROM Users WHERE user_email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String userEmail = resultSet.getString("user_email");
                String userPassword = resultSet.getString("user_password");
                setName(userName);
                setPassword(userPassword);
                setEmail(userEmail);
                return true;

            } else {
                System.out.println("User with email " + email + " not found.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return false;
    }


    public String getUserNameByEmail(String email) {
        try {
            Connection  connection= connectionUser.initializeConnection();
            String query = "SELECT * FROM Users WHERE user_email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                setName(userName);
                return userName;

            } else {
                System.out.println("User with email " + email + " not found.");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return null;
    }


    public ArrayList<User> getAllUser() {

        ArrayList<User> allUser = new ArrayList<>();

        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user=new User();

                String userName = resultSet.getString("user_name");
                String userEmail = resultSet.getString("user_email");

                user.setName(userName);
                user.setEmail(userEmail);
                allUser.add(user);

            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return allUser;
    }






}