package com.skillcube.driver.repository;

import com.skillcube.driver.exception.DriverNotFoundException;
import com.skillcube.driver.exception.DuplicateDriverIdException;
import com.skillcube.driver.util.AppConstant;
import com.skillcube.driver.entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class DriverRepository {

    Connection con = null;

    public Driver addDriver(Driver driver) throws DuplicateDriverIdException {
        try {
        	con= DriverManager.getConnection(AppConstant.dbURL, AppConstant.username, AppConstant.password);
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO driverdb.driver(driverid, firstname, telephonenumber, address, city, enginesize, quoteamount) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, driver.getDriverid());
            statement.setString(2, driver.getFirstname());
            statement.setString(3, driver.getTelephonenumber());
            statement.setString(4, driver.getAddress());
            statement.setString(5, driver.getCity());
            statement.setString(6, driver.getEnginesize());
            statement.setString(7, driver.getQuoteamount());
            statement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new DuplicateDriverIdException("Driver with id " + driver.getDriverid() + " already exists");
            }
            e.printStackTrace();
        }
        return driver;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try {
        	con= DriverManager.getConnection(AppConstant.dbURL, AppConstant.username, AppConstant.password);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DRIVERDB.DRIVER");
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setDriverid(resultSet.getInt("driverid"));
                driver.setFirstname(resultSet.getString("firstname"));
                driver.setTelephonenumber(resultSet.getString("telephonenumber"));
                driver.setAddress(resultSet.getString("address"));
                driver.setCity(resultSet.getString("city"));
                driver.setEnginesize(resultSet.getString("enginesize"));
                driver.setQuoteamount(resultSet.getString("quoteamount"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    
    public void deleteDriver(int driverid) throws DriverNotFoundException {
        try {
        	con= DriverManager.getConnection(AppConstant.dbURL, AppConstant.username, AppConstant.password);
            PreparedStatement stmt = con.prepareStatement("DELETE FROM driver WHERE driverid = ?");
            stmt.setInt(1, driverid);
            int result = stmt.executeUpdate();
            if (result == 0) {
                throw new DriverNotFoundException("Exception Occurs");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   	public int getDriverById(int driverid) {
		return driverid;
            	
            }

	
}