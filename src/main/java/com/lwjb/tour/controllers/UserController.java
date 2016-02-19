package com.lwjb.tour.controllers;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@RequiresRoles("user")
	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	public String userDashboard() {
		return "user/dashboard";
	}
	
}
