package com.spring.customermapper.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.customer.test.Customer;

public class CustomerMapper implements RowMapper<Customer>{
	@Override
	public Customer mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(arg0.getInt("id"));
		customer.setFname(arg0.getString("fname"));
		customer.setLname(arg0.getString("lname"));
		customer.setAddress(arg0.getString("address"));
		return customer;
}
}
