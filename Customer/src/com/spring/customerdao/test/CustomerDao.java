package com.spring.customerdao.test;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import com.spring.customer.test.Customer;

public interface CustomerDao {
	public Customer getCus(int id);
	public static String newCus(Customer customer)throws DuplicateKeyException {
		return null;
	}
	public void updateCus(Customer customer);
	public void deleteCus(int id);
	public List<Customer> listCus();
}
