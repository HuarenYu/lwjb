package com.lwjb.tour.controllers;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lwjb.tour.forms.AddItemForm;
import com.lwjb.tour.services.ItemService;

@Controller
@RequestMapping(path = "/item")
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "出发");
		return "item/index";
	}
	
	@RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
	public String item(@PathVariable long itemId, Model model) {
		model.addAttribute("title", "家园详情");
		return "item/item";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addItme(@Valid AddItemForm addItemForm, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/admin/item/add";
		}
		Long id = null;
		try {
			id = itemService.save(addItemForm);
		} catch(Exception e) {
			logger.error("add item error", e);
			return "redirect:/admin/item/add";
		}
		return "redirect:/item/" + id;
	}
	
}
