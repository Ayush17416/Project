package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementation of the HospitalDao interface using JDBC for MySQL database operations
public class HospitalDaoImpl implements HospitalDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blood_donation"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a hospital to the database
    @Override
    public void addHospital(Hospital hospital) {
        String query = "INSERT INTO hospitals (name, location) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hospital.getName());
            preparedStatement.setString(2, hospital.getLocation());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added hospital");
        } catch (SQLException exception) {
            System.out.println("Error while adding hospital: " + exception.getMessage());
        }
    }

    // Retrieves a hospital from the database by ID
    @Override
    public Hospital getHospitalById(int id) {
        String query = "SELECT * FROM hospitals WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Hospital(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting hospital: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all hospitals from the database
    @Override
    public List<Hospital> getAllHospital() {
        List<Hospital> hospitals = new ArrayList<>();
        String query = "SELECT * FROM hospitals";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hospitals.add(new Hospital(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("location")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all hospitals: " + exception.getMessage());
        }
        return hospitals;
    }

    // Updates a hospital's information in the database
    @Override
    public void updateHospital(Hospital hospital) {
        String query = "UPDATE hospitals SET name = ?, location = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hospital.getName());
            preparedStatement.setString(2, hospital.getLocation());
            preparedStatement.setInt(3, hospital.getId());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated hospital");
        } catch (SQLException exception) {
            System.out.println("Error while updating hospital: " + exception.getMessage());
        }
    }

    // Deletes a hospital from the database by ID
    @Override
    public void deleteHospital(int id) {
        String query = "DELETE FROM hospitals WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted hospital");
        } catch (SQLException exception) {
            System.out.println("Error while deleting hospital: " + exception.getMessage());
        }
    }
}
