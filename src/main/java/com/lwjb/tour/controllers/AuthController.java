package com.lwjb.tour.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lwjb.tour.exceptions.UserExistException;
import com.lwjb.tour.forms.LoginForm;
import com.lwjb.tour.forms.RegisterForm;
import com.lwjb.tour.services.UserService;

@Controller
@RequestMapping(value = { "/auth" })
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "auth/login";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String processLogin(LoginForm loginForm, HttpServletRequest request) {
        try {
            userService.login(loginForm);
        } catch (AuthenticationException e) {
        	logger.error("user name or password error!", e);
            return login();
        }
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        String redirectUrl = "";
        if (savedRequest != null && savedRequest.getRequestUrl().equals("")) {
        	savedRequest.getRequestUrl();
        } else {
        	redirectUrl = "/admin/dashboard";
        }
        return "redirect:" + redirectUrl;
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout() {
		userService.logout();
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register() {
		return "auth/register";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String processRegister(@Valid RegisterForm registerForm, BindingResult result) {
		try {
			userService.register(registerForm);
		} catch(UserExistException e) {
			logger.warn("username {} exist", registerForm.getUsername());
		} catch(Exception e) {
			logger.error("persist user error", e);
		}
		return "redirect:/auth/login";
	}
	
	@RequestMapping(value = { "/unauthorized" }, method = RequestMethod.GET)
	public String unauthorized() {
		return "auth/unauthorized";
	}
	
}
