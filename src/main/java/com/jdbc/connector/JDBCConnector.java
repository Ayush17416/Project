package com.jdbc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JDBCConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blood_donation";
    private static final String USER = "root";  // Change this to your MySQL username
    private static final String PASSWORD = "1983";  // Change this to your MySQL password

    public JDBCConnector() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.out.println("Error in connecting to database "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        DonorDao donorDao = new DonorDaoImpl();
        //Donor donor = new Donor("Ayush","B+","Delhi");
        //donorDao.addDonor(donor);
        List<Donor> donors = donorDao.getAllDonor();
        System.out.println(donors.toString());
    }
}
