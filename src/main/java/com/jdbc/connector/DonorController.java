package com.jdbc.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jdbc.Dao.*;
import com.jdbc.Model.*;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorDaoImpl donorDao;

    @PostMapping("/add")
    public String addDonor(@RequestParam String name,
                           @RequestParam String bloodType,
                           @RequestParam String location) {
        // Create a new donor object
        Donor donor = new Donor(name,bloodType,location);
        donorDao.addDonor(donor);
        return "Donor added successfully!";
    }

    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable int id) {
        return donorDao.getDonorById(id);
    }

    @GetMapping("/all")
    public List<Donor> getAllDonors() {
        return donorDao.getAllDonor();
    }

    @PutMapping("/update")
    public String updateDonor(@RequestBody Donor donor) {
        donorDao.updateDonor(donor);
        return "Donor updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDonor(@PathVariable int id) {
        donorDao.deleteDonor(id);
        return "Donor deleted successfully!";
    }
}
