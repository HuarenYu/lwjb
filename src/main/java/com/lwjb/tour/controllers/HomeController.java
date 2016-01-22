package com.lwjb.tour.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwjb.tour.models.City;
import com.lwjb.tour.services.CityService;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = { "" }, method = { RequestMethod.GET })
	public String index(Model model) {
		logger.debug("user visit index");
		try {
			throw new Exception("test exception.");
		} catch (Exception e) {
			logger.debug("oops!", e);
		}
		model.addAttribute("greet", "这是一个测试页面");
		return "home/index";
	}
	
	@RequestMapping(value = { "/about" }, method = { RequestMethod.GET })
	public @ResponseBody List<String> about() {
		logger.debug("user visit about");
		List<String> names = new ArrayList<>();
		names.add("ah bee family!");
		names.add("samsung!");
		return names;
	}
	
	@RequestMapping(value = { "/insertCity" }, method = { RequestMethod.GET })
	public @ResponseBody List<String> insertCity() {
		logger.debug("user visit insertCity");
		cityService.insertCity();
		List<String> names = new ArrayList<>();
		names.add("city inserted!");
		return names;
	}
	
	@RequestMapping(value = { "/cityList" }, method = { RequestMethod.GET })
	public @ResponseBody List<City> cityList() {
		logger.debug("user visit cityList");
		return cityService.getCityList();
	}
	
}
