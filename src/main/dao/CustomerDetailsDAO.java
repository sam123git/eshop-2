package main.dao;

import main.model.CustomerDetails;

public interface CustomerDetailsDAO {
	
	public CustomerDetails getById(long id);
	
	public void saveOrUpdate(CustomerDetails customerDetails);
	
	public void delete(long id);
	

}
