package main.service;

import java.util.List;

import main.model.Order;

public interface OrderService {
	
	public List<Order> getAll();
	
	public Order getById(long orderId);
	
	public void saveOrUpdate(Order order);
	
	public void delete(long orderId);

}
