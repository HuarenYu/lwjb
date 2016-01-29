package com.lwjb.tour.daos;

import java.util.List;

import com.lwjb.tour.forms.OrderForm;
import com.lwjb.tour.models.Order;

public interface OrderDao {
	
	public List<Order> findAll();
	
	public void save(OrderForm orderForm);
}
