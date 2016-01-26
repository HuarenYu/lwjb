package com.lwjb.tour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/post")
public class PostController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "分享");
		return "post/index";
	}
	
	@RequestMapping(path = "/{postId}", method = RequestMethod.GET)
	public String item(@PathVariable long itemId, Model model) {
		model.addAttribute("title", "分享");
		return "post/post";
	}
	
}
