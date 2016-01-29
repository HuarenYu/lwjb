package com.lwjb.tour.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwjb.tour.forms.AddItemForm;
import com.lwjb.tour.forms.UpdateItemForm;
import com.lwjb.tour.models.Item;
import com.lwjb.tour.services.ItemService;
import com.lwjb.tour.vos.JsonResponse;

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
		Item item = itemService.findById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("title", "家园详情");
		return "item/item";
	}
	
	@RequestMapping(path = "/{itemId}/order", method = RequestMethod.GET)
	public String itemOrder(@PathVariable long itemId, Model model) {
		Item item = itemService.findById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("title", "预定");
		return "item/itemOrder";
	}
	
	@RequiresRoles("admin")
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse<Item> addItme(@Valid AddItemForm addItemForm, BindingResult result) {
		JsonResponse<Item> jr = new JsonResponse<>();
		if (result.hasErrors()) {
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("参数错误");
		}
		Item item = null;
		try {
			item = itemService.save(addItemForm);
		} catch(Exception e) {
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("数据库错误");
		}
		jr.setStatusCode(JsonResponse.SUCCESS);
		jr.setData(item);
		return jr;
	}
	
	@RequiresRoles("admin")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse<Item> updateItme(@Valid UpdateItemForm updateItemForm, BindingResult result) {
		JsonResponse<Item> jr = new JsonResponse<>();
		if (result.hasErrors()) {
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("参数错误");
		}
		try {
			itemService.update(updateItemForm);
		} catch(Exception e) {
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("数据库错误");
		}
		jr.setStatusCode(JsonResponse.SUCCESS);
		jr.setStatusMsg("更新成功");
		return jr;
	}
	
	@RequestMapping(path = "/list/{page}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse<List<Item>> list(@PathVariable int page) {
		JsonResponse<List<Item>> jr = new JsonResponse<List<Item>>();
		jr.setStatusCode(JsonResponse.SUCCESS);
		jr.setData(itemService.findAll());
		return jr;
	}
	
}
