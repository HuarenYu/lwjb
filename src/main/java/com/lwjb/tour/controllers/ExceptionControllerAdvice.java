package com.lwjb.tour.controllers;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(UnauthorizedException.class)
	public String unauthorizedExceptionHandler(UnauthorizedException ex, HttpServletResponse response) {
		return "redirect:/auth/unauthorized";
	}
}
