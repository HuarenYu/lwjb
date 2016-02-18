package com.lwjb.tour.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = { "/about" })
public class AboutController {
	
	private final Logger logger = LoggerFactory.getLogger(AboutController.class);
	
	@RequestMapping(path = { "" }, method = { RequestMethod.GET })
	public String index(Model model) {
		model.addAttribute("title", "关于我们");
		return "about";
	}
	
}
