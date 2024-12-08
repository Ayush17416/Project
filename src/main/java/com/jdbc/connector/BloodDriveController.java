package com.jdbc.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jdbc.Dao.*;
import com.jdbc.Model.*;

@RestController
@RequestMapping("/blooddrive")
public class BloodDriveController {

    @Autowired
    private BloodDriveDaoImpl bloodDriveDao;

    @PostMapping("/add")
    public String addBloodDrive(@RequestBody BloodDrive bloodDrive) {
        bloodDriveDao.addBloodDrive(bloodDrive);
        return "Blood Drive added successfully!";
    }

    @GetMapping("/{id}")
    public BloodDrive getBloodDriveById(@PathVariable int id) {
        return bloodDriveDao.getBloodDriveById(id);
    }

    @GetMapping("/all")
    public List<BloodDrive> getAllBloodDrives() {
        return bloodDriveDao.getAllBloodDrives();
    }

    @PutMapping("/update")
    public String updateBloodDrive(@RequestBody BloodDrive bloodDrive) {
        bloodDriveDao.updateBloodDrive(bloodDrive);
        return "Blood Drive updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBloodDrive(@PathVariable int id) {
        bloodDriveDao.deleteBloodDrive(id);
        return "Blood Drive deleted successfully!";
    }
}
