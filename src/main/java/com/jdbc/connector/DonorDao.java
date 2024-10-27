package com.jdbc.connector;

import java.util.List;

// This interface defines the operations for managing Donor records in the data source
public interface DonorDao {
    // Adds a new donor to the data source
    void addDonor(Donor donor);

    // Retrieves a donor by their unique ID
    Donor getDonorById(int id);

    // Retrieves a list of all donors
    List<Donor> getAllDonor();

    // Updates the details of an existing donor
    void updateDonor(Donor donor);

    // Deletes a donor by their unique ID
    void deleteDonor(int id);
}
