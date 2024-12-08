package com.jdbc.Model;

import java.sql.Date;

// This class represents a Blood Drive event with details about its location and date
public class BloodDrive {
    private int id; // Unique identifier for the blood drive
    private String location; // Location of the blood drive
    private Date date; // Date of the blood drive

    // Constructor to initialize a BloodDrive object with an ID, location, and date
    public BloodDrive(int id, String location, Date date) {
        this.id = id;
        this.location = location;
        this.date = date;
    }

    public BloodDrive(String location) {
        this.location = location;
    }

    // Getter for the blood drive ID
    public int getId() {
        return id;
    }

    // Getter for the location of the blood drive
    public String getLocation() {
        return location;
    }

    // Getter for the date of the blood drive
    public Date getDate() {
        return date;
    }

    // Setter to update the blood drive ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter to update the location of the blood drive
    public void setLocation(String location) {
        this.location = location;
    }

    // Setter to update the date of the blood drive
    public void setDate(Date date) {
        this.date = date;
    }

    // Returns a string representation of the BloodDrive object
    @Override
    public String toString() {
        return "BloodDrive{id=" + id + ", location='" + location + "', date=" + date + '}';
    }
}
