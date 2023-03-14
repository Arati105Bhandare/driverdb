package com.skillcube.driver.controller;

import com.skillcube.driver.exception.DriverNotFoundException;
import com.skillcube.driver.exception.DuplicateDriverIdException;
import com.skillcube.driver.entity.Driver;
import com.skillcube.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) throws DuplicateDriverIdException {
        Driver newDriver = driverService.addDriver(driver);
        return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
    }

    @GetMapping("/allDrivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") int id) throws DriverNotFoundException {
        driverService.deleteDriver(id);
        return new ResponseEntity<>("Driver with id " + id + " has been deleted successfully", HttpStatus.OK);
    }

}
