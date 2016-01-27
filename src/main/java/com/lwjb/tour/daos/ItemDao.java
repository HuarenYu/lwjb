package com.lwjb.tour.daos;

import java.util.List;

import com.lwjb.tour.models.Item;

public interface ItemDao {
	
	public List<Item> findAll();
	
	public void save(Item item);
}
