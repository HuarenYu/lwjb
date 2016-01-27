package com.lwjb.tour.services;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwjb.tour.daos.UserDao;
import com.lwjb.tour.exceptions.UserExistException;
import com.lwjb.tour.forms.LoginForm;
import com.lwjb.tour.forms.RegisterForm;
import com.lwjb.tour.models.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public void login(LoginForm loginForm) {
		UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
		token.setRememberMe(loginForm.isRememberMe());
		Subject user = SecurityUtils.getSubject();
		user.login(token);
		logger.info("user {} login", loginForm.getUsername());
	}
	
	public void register(RegisterForm registerForm) throws UserExistException {
		User registerUser = userDao.findByUsername(registerForm.getUsername());
		if (registerUser != null) {
			throw new UserExistException();
		}
		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setPassword(passwordService.encryptPassword(registerForm.getPassword()));
		userDao.save(user);
		userDao.addRole(user.getId(), 1);
		logger.info("user {} register", user.getId());
	}
	
	public void logout() {
		Subject user = SecurityUtils.getSubject();
		user.logout();
	}
	
}
