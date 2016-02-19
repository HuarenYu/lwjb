package com.lwjb.tour.controllers;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwjb.tour.exceptions.InvalidBookDateException;
import com.lwjb.tour.forms.OrderForm;
import com.lwjb.tour.models.Order;
import com.lwjb.tour.services.OrderService;
import com.lwjb.tour.vos.JsonResponse;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	@RequiresRoles("user")
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse<Order> addOrder(@Valid OrderForm orderForm, BindingResult result) {
		JsonResponse<Order> jr = new JsonResponse<>();
		if (result.hasErrors()) {
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("参数错误");
			return jr;
		}
		try {
			orderService.save(orderForm);
		} catch(InvalidBookDateException e) {
			logger.error("添加订单失败", e);
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg(e.getMessage());
			return jr;
		} catch (Exception e) {
			logger.error("添加订单失败", e);
			jr.setStatusCode(JsonResponse.ERROR);
			jr.setStatusMsg("数据库错误");
			return jr;
		}
		jr.setStatusCode(JsonResponse.SUCCESS);
		return jr;
	}
	
}
