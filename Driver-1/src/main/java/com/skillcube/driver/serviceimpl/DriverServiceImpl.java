package com.skillcube.driver.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillcube.driver.entity.Driver;
import com.skillcube.driver.exception.DriverNotFoundException;
import com.skillcube.driver.exception.DuplicateDriverIdException;
import com.skillcube.driver.repository.DriverRepository;
import com.skillcube.driver.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
   
	@Autowired
    private DriverRepository driverRepository;

	@Override
	public Driver addDriver(Driver driver) throws DuplicateDriverIdException {
		return driverRepository.addDriver(driver);
	}

	@Override
	public List<Driver> getAllDrivers() {
	return	driverRepository.getAllDrivers();
	}

	@Override
	public void deleteDriver(int driverid) throws DriverNotFoundException {
		int driver = driverRepository.getDriverById(driverid);
		
		driverRepository.deleteDriver(driverid);
	}
	

	@Override
	public int getDriverById(int driverid) {
		return driverRepository.getDriverById(driverid);
	}

	
	
	
    
}
