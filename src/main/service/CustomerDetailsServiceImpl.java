package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CustomerDetailsDAO;
import main.model.CustomerDetails;

@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService{
	
	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;

	@Override
	public CustomerDetails getById(long id) {
		return customerDetailsDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(CustomerDetails customerDetails) {
		customerDetailsDAO.saveOrUpdate(customerDetails);
	}

	@Override
	public void delete(long id) {
		customerDetailsDAO.delete(id);
	}

}
