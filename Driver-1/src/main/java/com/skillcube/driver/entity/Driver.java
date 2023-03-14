package com.skillcube.driver.entity;

public class Driver {

	private int driverid;
	private String firstname;
	private String telephonenumber;
	private String address;
	private String city;
	private String enginesize;
	private String quoteamount;
	
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEnginesize() {
		return enginesize;
	}
	public void setEnginesize(String enginesize) {
		this.enginesize = enginesize;
	}
	public String getQuoteamount() {
		return quoteamount;
	}
	public void setQuoteamount(String quoteamount) {
		this.quoteamount = quoteamount;
	}
	public Driver() {
		super();
	}
	public Driver(int driverid, String firstname, String telephonenumber, String address, String city,
			String enginesize, String quoteamount) {
		super();
		this.driverid = driverid;
		this.firstname = firstname;
		this.telephonenumber = telephonenumber;
		this.address = address;
		this.city = city;
		this.enginesize = enginesize;
		this.quoteamount = quoteamount;
	}
	
	
	
	
	
	
}
