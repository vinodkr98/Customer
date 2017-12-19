package com.spring.homecontroller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customer.test.Customer;
import com.spring.customerdao.test.CustomerDao;



@RestController
public class HomeController {
	
@Autowired
private CustomerDao customerDao;
	
@RequestMapping(value = "/customers", method = RequestMethod.GET, headers = "Accept=application/json")

public List<Customer> getCustomers(){
	List<Customer> listOfCustomers = customerDao.listCus();
	return listOfCustomers;
}

@RequestMapping(value = "/customer{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
public Customer getCustomerById(@PathVariable int id) {  
 return customerDao.getCus(id);  
} 
@RequestMapping(value = "/Customers", method = RequestMethod.PUT, headers = "Accept=application/json")  
public String newCustomer(@RequestBody Customer customer) {  
 return CustomerDao.newCus(customer);  
}  

@RequestMapping(value = "/Customers{id}", method = RequestMethod.POST, headers = "Accept=application/json")  
public Customer updateCus(@RequestBody Customer customer) {  
 customerDao.updateCus(customer);  
 return customer;
}

@RequestMapping(value = "/Customer{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
public void deleteCustomer(@PathVariable("id") int id) {  
	customerDao.deleteCus(id);  
 
}  

}