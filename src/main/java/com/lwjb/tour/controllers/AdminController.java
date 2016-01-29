package com.lwjb.tour.controllers;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lwjb.tour.models.Item;
import com.lwjb.tour.services.ItemService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private ItemService itemService;
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/dashboard" }, method = { RequestMethod.GET })
	public String dashboard(Model model) {
		model.addAttribute("title", "后台管理");
		return "admin/dashboard";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/item" }, method = { RequestMethod.GET })
	public String item(Model model) {
		model.addAttribute("title", "房屋管理");
		return "admin/item";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/item/add" }, method = { RequestMethod.GET })
	public String itemAdd(Model model) {
		model.addAttribute("title", "添加房屋");
		return "admin/itemAdd";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/item/edit/{itemId}" }, method = { RequestMethod.GET })
	public String itemEdit(@PathVariable long itemId, Model model) {
		Item item = itemService.findById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("title", "编辑房屋");
		return "admin/itemEdit";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/order" }, method = { RequestMethod.GET })
	public String order(Model model) {
		model.addAttribute("title", "订单管理");
		return "admin/order";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = { "/setting" }, method = { RequestMethod.GET })
	public String setting(Model model) {
		model.addAttribute("title", "设置");
		return "admin/setting";
	}
	
	@RequiresPermissions("user:*")
	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	public String user(Model model) {
		return "admin/user";
	}
	
}
