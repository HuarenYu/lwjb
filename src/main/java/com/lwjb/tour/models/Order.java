package com.lwjb.tour.models;

import java.sql.Timestamp;

public class Order {
	
	private long id;
	private String consumerName;
	private String consumerPhone;
	private String consumerId;
	private int consumerCount;
	private String bookedDates;
	private double totalPrice;
	private long userId;
	private long shopId;
	private int status;
	private String comment;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public int getConsumerCount() {
		return consumerCount;
	}
	public void setConsumerCount(int consumerCount) {
		this.consumerCount = consumerCount;
	}
	public String getBookedDates() {
		return bookedDates;
	}
	public void setBookedDates(String bookedDates) {
		this.bookedDates = bookedDates;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
