package com.jdbc.connector;

import java.util.List;

// This interface defines the operations for managing Hospital records in the data source
public interface HospitalDao {
    // Adds a new hospital to the data source
    void addHospital(Hospital hospital);

    // Retrieves a hospital by its unique ID
    Hospital getHospitalById(int id);

    // Retrieves a list of all hospitals
    List<Hospital> getAllHospital();

    // Updates the details of an existing hospital
    void updateHospital(Hospital hospital);

    // Deletes a hospital by its unique ID
    void deleteHospital(int id);
}
