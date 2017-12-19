package com.spring.customerdaoimpl.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.customer.test.Customer;
import com.spring.customerdao.test.CustomerDao;

public class CustomerDaoImp implements CustomerDao  {
	private JdbcTemplate jdbcTemplate;
	 
    public CustomerDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Customer getCus(int id) {
		// TODO Auto-generated method stub
		String query = "select * from customer where id=" + id;
		return jdbcTemplate.query(query, new ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet arg0) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (arg0.next()) {
					Customer customer = new Customer();
					customer.setId(arg0.getInt("id"));
					customer.setFname(arg0.getString("fname"));
					customer.setLname(arg0.getString("lname"));
					customer.setAddress(arg0.getString("address"));
					return customer;
				}
				return null;
			}

		});
	}

	@Override
	public void updateCus(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getId() > 0) {
			String query = "update employee set fname=?, lname=?, address=? where id=?";
			jdbcTemplate.update(query, customer.getFname(),customer.getLname(),customer.getAddress(), customer.getId());
		}

	}

	@Override
	public void deleteCus(int id) {
		// TODO Auto-generated method stub
		String query = "delete from customer where id=?";
		jdbcTemplate.update(query, id);

	}

	@Override
	public List<Customer> listCus() {
		// TODO Auto-generated method stub
		String query = "select * from customer";
		List<Customer> listCustomer = jdbcTemplate.query(query, new RowMapper<Customer>(){

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
			
		});
		
		return listCustomer;
	}


	public String newCus(Customer customer) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		try {
			String query = "insert into customer (id, fname, lname, address) values(?, ?, ?, ?)";
			jdbcTemplate.update(query, customer.getId(), customer.getFname(), customer.getLname(), customer.getAddress());
			return "Success";
		} catch (DuplicateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Id already exists";
		}

	}


}
