package com.lwjb.tour.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwjb.tour.daos.ItemDao;
import com.lwjb.tour.daos.OrderDao;
import com.lwjb.tour.daos.UserDao;
import com.lwjb.tour.exceptions.UserExistException;
import com.lwjb.tour.forms.LoginForm;
import com.lwjb.tour.forms.OrderForm;
import com.lwjb.tour.forms.RegisterForm;
import com.lwjb.tour.models.Item;
import com.lwjb.tour.models.Order;
import com.lwjb.tour.models.User;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	public void save(OrderForm orderForm) {
		Item item = itemDao.findByIdForUpdate(orderForm.getItemId());
		LocalDate startDate = orderForm.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = orderForm.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String[] bookedDates = objectMapper.readValue(item.getBookedDates(), String[].class);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//判断预订的日期是否已经被预订
			boolean isRepeat = false;
			for (String bookedDateStr : bookedDates) {
				LocalDate bookedDate = LocalDate.parse(bookedDateStr, dateTimeFormatter);
				if (bookedDate.isAfter(startDate) && bookedDate.isBefore(endDate)) {
					isRepeat = true;
					break;
				}
			}
			if (isRepeat) {
				
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Order order = new Order();
		orderDao.save(order);
	}
	
}
