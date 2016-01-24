package com.lwjb.tour.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/" })
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = { "" }, method = { RequestMethod.GET })
	public String index(Model model) {
		model.addAttribute("title", "首页");
		return "index";
	}
	
	@RequestMapping(value = { "/about" }, method = { RequestMethod.GET })
	public String about(Model model) {
		return "about";
	}
	
}
