package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.CustomerDetails;

@Repository
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CustomerDetails getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CustomerDetails.class, id);
	}

	@Override
	public void saveOrUpdate(CustomerDetails customerDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerDetails);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		CustomerDetails customerDetails =getById(id);
		session.delete(customerDetails);
	}
	
	

}
