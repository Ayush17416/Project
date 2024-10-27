package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementation of the DonorDao interface using JDBC for MySQL database operations
public class DonorDaoImpl implements DonorDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blood_donation"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a donor to the database
    @Override
    public void addDonor(Donor donor) {
        String query = "INSERT INTO donors (name, blood_type, location) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donor.getName());
            preparedStatement.setString(2, donor.getBloodType());
            preparedStatement.setString(3, donor.getLocation());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added donor");
        } catch (SQLException exception) {
            System.out.println("Error while adding donor: " + exception.getMessage());
        }
    }

    // Retrieves a donor from the database by ID
    @Override
    public Donor getDonorById(int id) {
        String query = "SELECT * FROM donors WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Donor(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting donor: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all donors from the database
    @Override
    public List<Donor> getAllDonor() {
        List<Donor> donors = new ArrayList<>();
        String query = "SELECT * FROM donors";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                donors.add(new Donor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("blood_type"),
                        resultSet.getString("location")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all donors: " + exception.getMessage());
        }
        return donors;
    }

    // Updates a donor's information in the database
    @Override
    public void updateDonor(Donor donor) {
        String query = "UPDATE donors SET name = ?, blood_type = ?, location = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donor.getName());
            preparedStatement.setString(2, donor.getBloodType());
            preparedStatement.setString(3, donor.getLocation());
            preparedStatement.setInt(4, donor.getId());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated donor");
        } catch (SQLException exception) {
            System.out.println("Error while updating donor: " + exception.getMessage());
        }
    }

    // Deletes a donor from the database by ID
    @Override
    public void deleteDonor(int id) {
        String query = "DELETE FROM donors WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted donor");
        } catch (SQLException exception) {
            System.out.println("Error while deleting donor: " + exception.getMessage());
        }
    }
}
