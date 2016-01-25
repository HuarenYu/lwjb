package com.lwjb.tour.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = { "/mall" })
public class MallController {
	
	private final Logger logger = LoggerFactory.getLogger(MallController.class);
	
	@RequestMapping(path = { "" }, method = { RequestMethod.GET })
	public String index(Model model) {
		model.addAttribute("title", "特产");
		return "mall/index";
	}
	
}
