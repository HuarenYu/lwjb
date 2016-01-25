package com.lwjb.tour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/item")
public class ItemController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String index() {
		return "item/item";
	}
	
	@RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
	public String item(@PathVariable long itemId) {
		return "item/item";
	}
	
}
