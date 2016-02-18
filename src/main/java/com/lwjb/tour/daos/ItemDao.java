package com.lwjb.tour.daos;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwjb.tour.forms.UpdateItemForm;
import com.lwjb.tour.models.Item;

public interface ItemDao {
	
	public List<Item> findAll();
	
	public void save(Item item);

	public Item findById(@Param("itemId") long itemId);
	
	public Item findByIdForUpdate(@Param("itemId") long itemId);
	
	public void update(UpdateItemForm updateItemForm);
	
	public void updateBookedDates(Item item);
}
