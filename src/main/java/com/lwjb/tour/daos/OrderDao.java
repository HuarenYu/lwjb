package com.lwjb.tour.daos;

import java.util.List;

import com.lwjb.tour.models.Order;
import com.lwjb.tour.models.OrderItem;

public interface OrderDao {
	
	public List<Order> findAll();
	
	public void save(Order order);
	
	public void addOrderItem(OrderItem orderItem);
	
}
