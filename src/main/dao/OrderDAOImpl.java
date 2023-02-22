package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Order o", Order.class).list();
	}

	@Override
	@Transactional
	public Order getById(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, orderId);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

	@Override
	@Transactional
	public void delete(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		Order order = getById(orderId);
		session.delete(order);
	}

}
