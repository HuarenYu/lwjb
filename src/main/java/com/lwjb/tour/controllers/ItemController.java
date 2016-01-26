package com.lwjb.tour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/item")
public class ItemController {

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
	
}
