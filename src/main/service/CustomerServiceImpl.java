package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CustomerDAO;
import main.model.Customer;
import main.model.CustomerDetails;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	@Override
	public Customer getById(long id) {
		return customerDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		customerDAO.saveOrUpdate(customer);
		
	}

	@Override
	public void delete(long id) {
		customerDAO.delete(id);
		
	}

	@Override
	public void addCustomerDetailsIfNotExists(Customer customer) {
		if(customer.getCustomerDetails() == null) {
			customer.setCustomerDetails(new CustomerDetails());
			saveOrUpdate(customer);
		}		
	}

	@Override
	public Customer getByIdWithComments(long id) {
		return customerDAO.getByIdWithComments(id);
	}
	
	

}
