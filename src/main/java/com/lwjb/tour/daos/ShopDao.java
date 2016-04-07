package com.lwjb.tour.daos;

import org.apache.ibatis.annotations.Param;

import com.lwjb.tour.models.Shop;

public interface ShopDao {
	
	public Shop findById(@Param("shopId") long shopId);
	
	public Shop findByUserId(@Param("userId") long userId);

}
