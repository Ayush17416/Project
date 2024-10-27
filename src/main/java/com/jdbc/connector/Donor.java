package com.jdbc.connector;

// This class represents a Donor with attributes like ID, name, blood type, and location
public class Donor {
    private int id; // Donor's unique identifier
    private String name; // Donor's name
    private String bloodType; // Donor's blood type
    private String location; // Donor's location

    // Constructor to initialize a Donor object with specific values for each attribute
    public Donor(int id, String name, String bloodType, String location) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.location = location;
    }

    public Donor(String name, String bloodType, String location) {
        this.name = name;
        this.bloodType = bloodType;
        this.location = location;
    }

    // Getter for donor's ID
    public int getId() {
        return id;
    }

    // Getter for donor's name
    public String getName() {
        return name;
    }

    // Getter for donor's blood type
    public String getBloodType() {
        return bloodType;
    }

    // Getter for donor's location
    public String getLocation() {
        return location;
    }

    // Setter to update donor's ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter to update donor's name
    public void setName(String name) {
        this.name = name;
    }

    // Setter to update donor's blood type
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    // Setter to update donor's location
    public void setLocation(String location) {
        this.location = location;
    }

    // Overrides the toString() method to provide a string representation of the Donor object
    @Override
    public String toString() {
        return "Donor{id=" + id + ", name='" + name + "', bloodType='" + bloodType + "', location='" + location + "'}";
    }
}
