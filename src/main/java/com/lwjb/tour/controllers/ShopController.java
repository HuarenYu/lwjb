package com.lwjb.tour.controllers;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwjb.tour.models.Item;
import com.lwjb.tour.models.Shop;
import com.lwjb.tour.models.User;
import com.lwjb.tour.services.ItemService;
import com.lwjb.tour.services.ShopService;
import com.lwjb.tour.vos.JsonResponse;

@Controller
@RequestMapping(path = "/shop")
public class ShopController {
	
	Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private ShopService shopService;
	@Autowired
	private ItemService itemService;
	
	@RequiresRoles("user")
	@RequestMapping(path = "/user/item")
	@ResponseBody
	public JsonResponse<List<Item>> shopItems() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		User user = (User) session.getAttribute("user");
		JsonResponse<List<Item>> jr = new JsonResponse<List<Item>>();
		try {
			Shop shop = shopService.findByUser(user);
			List<Item> items = itemService.findByShop(shop);
			jr.setData(items);
			jr.setStatusCode(JsonResponse.SUCCESS);
		} catch (Exception e) {
			logger.error("query shop error", e);
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("内部服务错误");
		}
		return jr;
	}
	
}
