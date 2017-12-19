package com.spring.customer.test;

public class Customer {
	
	private int id;
    private String fname;
    private String lname;
    private String address;
    
    public Customer() {
    }
    
    public Customer(int id,String fname,String lname,String address) {
    	this.id = id;
    	this.fname = fname;
    	this.lname = lname;
    	this.address = address;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
