package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementation of the BloodDriveDao interface using JDBC for MySQL database operations
public class BloodDriveDaoImpl implements BloodDriveDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blood_donation"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a new blood drive to the database
    @Override
    public void addBloodDrive(BloodDrive bloodDrive) {
        String query = "INSERT INTO blood_drives (location, date) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bloodDrive.getLocation());
            preparedStatement.setDate(2, bloodDrive.getDate());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added blood drive");
        } catch (SQLException exception) {
            System.out.println("Error while adding blood drive: " + exception.getMessage());
        }
    }

    // Retrieves a blood drive from the database by ID
    @Override
    public BloodDrive getBloodDriveById(int id) {
        String query = "SELECT * FROM blood_drives WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new BloodDrive(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting blood drive: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all blood drives from the database
    @Override
    public List<BloodDrive> getAllBloodDrive() {
        List<BloodDrive> bloodDrives = new ArrayList<>();
        String query = "SELECT * FROM blood_drives";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bloodDrives.add(new BloodDrive(
                        resultSet.getInt("id"),
                        resultSet.getString("location"),
                        resultSet.getDate("date")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all blood drives: " + exception.getMessage());
        }
        return bloodDrives;
    }

    // Updates the details of an existing blood drive in the database
    @Override
    public void updateBloodDrive(BloodDrive bloodDrive) {
        String query = "UPDATE blood_drives SET location = ?, date = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bloodDrive.getLocation());
            preparedStatement.setDate(2, bloodDrive.getDate());
            preparedStatement.setInt(3, bloodDrive.getId());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated blood drive");
        } catch (SQLException exception) {
            System.out.println("Error while updating blood drive: " + exception.getMessage());
        }
    }

    // Deletes a blood drive from the database by ID
    @Override
    public void deleteBloodDrive(int id) {
        String query = "DELETE FROM blood_drives WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted blood drive");
        } catch (SQLException exception) {
            System.out.println("Error while deleting blood drive: " + exception.getMessage());
        }
    }
}
