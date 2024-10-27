package com.jdbc.connector;

// This class represents a Hospital with attributes like ID, name, and location
public class Hospital {
    private int id; // Hospital's unique identifier
    private String name; // Hospital's name
    private String location; // Hospital's location

    // Constructor to initialize a Hospital object with specific values for each attribute
    public Hospital(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getter for hospital's ID
    public int getId() {
        return id;
    }

    // Getter for hospital's name
    public String getName() {
        return name;
    }

    // Getter for hospital's location
    public String getLocation() {
        return location;
    }

    // Setter to update hospital's ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter to update hospital's name
    public void setName(String name) {
        this.name = name;
    }

    // Setter to update hospital's location
    public void setLocation(String location) {
        this.location = location;
    }

    // Overrides the toString() method to provide a string representation of the Hospital object
    @Override
    public String toString() {
        return "Hospital{id=" + id + ", name='" + name + "', location='" + location + "'}";
    }
}
