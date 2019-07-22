package model.dao;

import java.util.List;

import model.entity.Order;

public interface OrderDao {
	
	Order createOrder(Order order);
	Order getById(int id);
	List<Order> getByCheck(int id);
	List<Order> getAllOrders();
	List<Order> getReturned();
	void update(Order order);
	void delete(int id);
	void deleteByCarId(int id);
}
