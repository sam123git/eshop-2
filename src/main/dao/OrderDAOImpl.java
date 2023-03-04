package main.dao;

import main.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//在JPQL语法中，select a from 类名 a 这语句中的类名其实不只是参照你的实体类名，他会优先参照的是你在实体类上使用的注解@Entity(name = "tab_admin")中的自定义name字段
	//"from orders o"中的orders位置要用Order.java內的 @Entity(name = "orders") 的"orders"
	@Override
	public List<Order> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from orders o", Order.class).list();
	}

	@Override
	public Order getById(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, orderId);
	}
	
	@Override
	public void saveOrUpdate(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

	@Override
	public void delete(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		Order order = getById(orderId);
		session.delete(order);
	}

}
