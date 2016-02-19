package com.lwjb.tour.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwjb.tour.daos.ItemDao;
import com.lwjb.tour.daos.OrderDao;
import com.lwjb.tour.daos.UserDao;
import com.lwjb.tour.exceptions.InvalidBookDateException;
import com.lwjb.tour.forms.OrderForm;
import com.lwjb.tour.models.Item;
import com.lwjb.tour.models.Order;
import com.lwjb.tour.models.OrderItem;
import com.lwjb.tour.models.User;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	public void save(OrderForm orderForm) throws JsonParseException, JsonMappingException, 
												IOException, InvalidBookDateException {
		Item item = itemDao.findByIdForUpdate(orderForm.getItemId());
		LocalDate startDate = orderForm.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = orderForm.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> bookedDates = objectMapper.readValue(item.getBookedDates(), new TypeReference<List<String>>(){});
		//判断预订的日期是否已经被预订
		boolean isRepeat = false;
		for (String bookedDateStr : bookedDates) {
			LocalDate bookedDate = LocalDate.parse(bookedDateStr, DateTimeFormatter.ISO_DATE);
			if (bookedDate.isAfter(startDate) && bookedDate.isBefore(endDate)) {
				isRepeat = true;
				break;
			}
		}
		if (isRepeat) {
			throw new InvalidBookDateException("您预订的日期当中包含已经被预订的日期");
		}
		Order order = new Order();
		List<String> consumerBookDates = new ArrayList<String>();
		LocalDate itrDate = startDate;
		while (itrDate.isBefore(endDate) || itrDate.isEqual(endDate)) {
			consumerBookDates.add(itrDate.toString());
			itrDate = itrDate.plusDays(1);
		}
		order.setBookedDates(objectMapper.writeValueAsString(consumerBookDates));
		order.setConsumerName(orderForm.getConsumerName());
		order.setConsumerPhone(orderForm.getConsumerPhone());
		order.setConsumerCount(orderForm.getConsumerCount());
		double totalPrice = item.getPrice() * consumerBookDates.size() * orderForm.getConsumerCount();
		order.setTotalPrice(totalPrice);
		order.setShopId(item.getShopId());
		Subject currentUser = SecurityUtils.getSubject();
		User user = userDao.findByUsername(currentUser.getPrincipal().toString());
		order.setUserId(user.getId());
		order.setComment(orderForm.getComment());
		orderDao.save(order);
		//添加订单商品关系表
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(item.getId());
		orderItem.setOrderId(order.getId());
		orderItem.setPrice(item.getPrice());
		orderItem.setBuyAmount(consumerBookDates.size());
		orderDao.addOrderItem(orderItem);
		//更新可预订日期
		bookedDates.addAll(consumerBookDates);
		item.setBookedDates(objectMapper.writeValueAsString(bookedDates));
		itemDao.updateBookedDates(item);
		logger.info("user {} add order {}", user.getId(), order.getId());
	}
	
}
