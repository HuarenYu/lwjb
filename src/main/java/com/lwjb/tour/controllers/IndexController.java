package com.lwjb.tour.controllers;

import java.io.IOException;
import java.util.List;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(path = "/fileUpload", method = { RequestMethod.GET })
	public String fileUpload() {
		return "fileUpload";
	}
	
	@RequestMapping(path = "/proccessFileUpload", method = { RequestMethod.POST })
	public String processFileUpload(MultipartFile image) {
		try {
			Thumbnails
			.of(image.getInputStream())
			.size(600, 800)
			.toFile("/Users/huarenyu/work/lwjb/target/test.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/fileUpload";
	}
}
