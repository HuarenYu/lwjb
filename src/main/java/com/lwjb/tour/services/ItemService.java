package com.lwjb.tour.services;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwjb.tour.daos.ItemDao;
import com.lwjb.tour.daos.UserDao;
import com.lwjb.tour.exceptions.UserExistException;
import com.lwjb.tour.forms.AddItemForm;
import com.lwjb.tour.forms.LoginForm;
import com.lwjb.tour.forms.RegisterForm;
import com.lwjb.tour.forms.UpdateItemForm;
import com.lwjb.tour.models.Item;
import com.lwjb.tour.models.Shop;
import com.lwjb.tour.models.User;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}
	
	public Item save(AddItemForm addItemForm) {
		Item item = new Item();
		item.setName(addItemForm.getName());
		item.setDescription(addItemForm.getDescription());
		item.setDetails(addItemForm.getDetails());
		item.setPrice(addItemForm.getPrice());
		item.setImages("[{\"src\":\""+addItemForm.getImages()+"\"}]");
		itemDao.save(item);
		return item;
	}
	
	public Item findById(long itemId) {
		return itemDao.findById(itemId);
	}
	
	public List<Item> findByShop(Shop shop) {
		return itemDao.findByShopId(shop.getId());
	}

	public void update(UpdateItemForm updateItemForm) {
		itemDao.update(updateItemForm);
	}
}
