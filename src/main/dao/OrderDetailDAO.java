package main.dao;

import main.model.OrderDetail;

public interface OrderDetailDAO {

    public OrderDetail getById(long orderDetailId);

    public void saveOrUpdate(OrderDetail orderDetail);

    public void delete(long orderDetailId);

}
