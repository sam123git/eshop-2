package main.service;

import java.util.List;

import main.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	
	public Customer getById(long customerId);
	
	public void saveOrUpdate(Customer customer);
	
	public void delete(long customerId);
	
//	public Customer getByIdWithComments(long customerId);
	
	public void addUserToCustomer(long customerId, String login);
	
//	public void addUserToCustomer(long customerId, long userId);

}
