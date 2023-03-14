package com.skillcube.driver.service;

import java.util.List;

import com.skillcube.driver.entity.Driver;
import com.skillcube.driver.exception.DriverNotFoundException;
import com.skillcube.driver.exception.DuplicateDriverIdException;

public interface DriverService {
	
    public Driver addDriver(Driver driver) throws DuplicateDriverIdException;
    
    public List<Driver> getAllDrivers();
    
    void deleteDriver(int driverid) throws DriverNotFoundException;

	public int getDriverById(int driverid);
}