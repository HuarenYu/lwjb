package com.lwjb.tour.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lwjb.tour.daos.ItemDao;
import com.lwjb.tour.models.Item;
import com.lwjb.tour.services.ItemService;

@Controller
@RequestMapping(path = { "/" })
public class IndexController {
	@Autowired
	private ItemService itemService;
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(path = { "" }, method = { RequestMethod.GET })
	public String index(Model model) {
		List<Item> items = itemService.findAll();
		model.addAttribute("title", "首页");
		return "index";
	}
	
}
