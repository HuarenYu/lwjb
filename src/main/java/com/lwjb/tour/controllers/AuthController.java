package com.lwjb.tour.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lwjb.tour.exceptions.UserExistException;
import com.lwjb.tour.forms.LoginForm;
import com.lwjb.tour.forms.RegisterForm;
import com.lwjb.tour.services.UserService;
import com.lwjb.tour.vos.JsonResponse;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Controller
@RequestMapping(value = { "/auth" })
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private WxMpService wxMpService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value="next", defaultValue="") String next) {
		model.addAttribute("title", "登陆");
		model.addAttribute("next", next);
		return "auth/login";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String processLogin(LoginForm loginForm,
								HttpServletRequest request,
								Model model,
								@RequestParam(value="next", defaultValue="") String next) {
        try {
            userService.login(loginForm);
        } catch (AuthenticationException e) {
        	logger.info("user name or password error!", e);
        	model.addAttribute("title", "登陆");
            return "auth/login";
        }
        String redirectUrl;
        if (next != null && !next.equals("")) {
        	redirectUrl = next;
        } else {
        	redirectUrl = "/";
        }
        return "redirect:" + redirectUrl;
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout() {
		userService.logout();
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("title", "注册");
		return "auth/register";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String processRegister(@Valid RegisterForm registerForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "注册");
			return "auth/register";
		}
		try {
			userService.register(registerForm);
		} catch(UserExistException e) {
			logger.info("username {} exist", registerForm.getUsername());
		} catch(Exception e) {
			logger.error("persist user error", e);
		}
		return "redirect:/auth/login";
	}
	
	@RequestMapping(value = { "/unauthorized" }, method = RequestMethod.GET)
	public String unauthorized(@RequestHeader(value = "X-Requested-With", defaultValue = "") String XRequestWith, Model model) {
		model.addAttribute("title", "消息");
		return "auth/unauthorized";
	}
	
	@RequestMapping(path = { "/xhr/unauthorized" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public JsonResponse<String> unauthorizedXhr(@RequestHeader(value = "X-Requested-With", defaultValue = "") String XRequestWith) {
		JsonResponse<String> jr = new JsonResponse<>();
		jr.setStatusCode(JsonResponse.ERROR);
		jr.setStatusMsg("无访问权限");
		return jr;
	}
	
	@RequestMapping(path = { "/xhr/unauthenticated" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public JsonResponse<String> unauthenticatedXhr(@RequestHeader(value = "X-Requested-With", defaultValue = "") String XRequestWith) {
		JsonResponse<String> jr = new JsonResponse<>();
		jr.setStatusCode(JsonResponse.ERROR);
		jr.setStatusMsg("需要登录");
		return jr;
	}
	
	@RequestMapping(path = "/oauth2/weixin", method = RequestMethod.GET)
	public String wxLogin() {
		return "redirect:" + wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_USER_INFO, null);
	}
	
	@RequestMapping(path = "/login/weixin", method = RequestMethod.GET)
	public String proccessWxLogin(@RequestParam String code) {
		try {
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
			WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
		} catch (WxErrorException e) {
			logger.error("weixin login error", e);
		}
		return "";
	}
	
}
