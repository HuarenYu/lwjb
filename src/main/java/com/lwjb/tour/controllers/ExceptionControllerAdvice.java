package com.lwjb.tour.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(UnauthorizedException.class)
	public String unauthorizedExceptionHandler(UnauthorizedException ex, HttpServletRequest req) {
		String xRequestWith = req.getHeader("X-Requested-With");
		if (xRequestWith != null && xRequestWith.equals("XMLHttpRequest")) {
			return "forward:/auth/xhr/unauthorized";
		}
		return "redirect:/auth/unauthorized";
	}
	
	@ExceptionHandler(UnauthenticatedException.class)
	public String unauthenticatedExceptionHandler(UnauthenticatedException ex, HttpServletRequest req) {
		String xRequestWith = req.getHeader("X-Requested-With");
		if (xRequestWith != null && xRequestWith.equals("XMLHttpRequest")) {
			return "forward:/auth/xhr/unauthenticated";
		}
		return "redirect:/auth/login";
	}
}
