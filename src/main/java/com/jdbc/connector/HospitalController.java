package com.jdbc.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jdbc.Dao.*;
import com.jdbc.Model.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalDaoImpl hospitalDao;

    @PostMapping("/add")
    public String addHospital(@RequestBody Hospital hospital) {
        hospitalDao.addHospital(hospital);
        return "Hospital added successfully!";
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable int id) {
        return hospitalDao.getHospitalById(id);
    }

    @GetMapping("/all")
    public List<Hospital> getAllHospitals() {
        return hospitalDao.getAllHospitals();
    }

    @PutMapping("/update")
    public String updateHospital(@RequestBody Hospital hospital) {
        hospitalDao.updateHospital(hospital);
        return "Hospital updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHospital(@PathVariable int id) {
        hospitalDao.deleteHospital(id);
        return "Hospital deleted successfully!";
    }
}
