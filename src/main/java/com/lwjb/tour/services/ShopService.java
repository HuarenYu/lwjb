package com.lwjb.tour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwjb.tour.daos.ShopDao;
import com.lwjb.tour.models.Shop;
import com.lwjb.tour.models.User;

@Service
@Transactional
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	public Shop findByUser(User user) {
		return shopDao.findByUserId(user.getId());
	}
	
}
