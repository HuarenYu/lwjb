package com.lwjb.tour.controllers;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/dashboard" }, method = { RequestMethod.GET })
	public String dashboard(Model model) {
		return "admin/dashboard";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/item" }, method = { RequestMethod.GET })
	public String item(Model model) {
		return "admin/item";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/order" }, method = { RequestMethod.GET })
	public String order(Model model) {
		return "admin/order";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/setting" }, method = { RequestMethod.GET })
	public String setting(Model model) {
		return "admin/setting";
	}
	
	@RequiresPermissions("user:*")
	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	public String user(Model model) {
		return "admin/user";
	}
}
