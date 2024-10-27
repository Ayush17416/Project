package com.jdbc.connector;

import java.util.List;

// Interface for CRUD operations related to BloodDrive entities in the database
public interface BloodDriveDao {

    // Adds a new BloodDrive record to the database
    void addBloodDrive(BloodDrive bloodDrive);

    // Retrieves a BloodDrive record by its ID
    BloodDrive getBloodDriveById(int id);

    // Retrieves all BloodDrive records from the database
    List<BloodDrive> getAllBloodDrive();

    // Updates an existing BloodDrive record in the database
    void updateBloodDrive(BloodDrive bloodDrive);

    // Deletes a BloodDrive record from the database by ID
    void deleteBloodDrive(int id);
}
