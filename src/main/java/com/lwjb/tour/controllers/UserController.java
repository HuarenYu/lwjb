package com.lwjb.tour.controllers;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lwjb.tour.services.ItemService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	private ItemService itemService;
	
	@RequiresRoles("user")
	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	public String index() {
		return "user/dashboard";
	}
	
	@RequiresRoles("user")
	@RequestMapping(path = "/addItem", method = RequestMethod.GET)
	public String addItem() {
		return "user/addItem";
	}
	
	@RequiresRoles("user")
	@RequestMapping(path = "/item", method = RequestMethod.GET)
	public String item() {
		return "user/item";
	}
	
}
