package com.lwjb.tour.forms;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class OrderForm {
	
	@NotNull
	@Size(min = 1, max = 20)
	private String consumerName;
	@NotNull
	@Size(min = 6, max = 16)
	private String consumerPhone;
	@NotNull
	@Min(1)
	private int consumerCount;
	@NotNull
	private long userId;
	@NotNull
	private long itemId;
	@NotNull
	@Future
	@DateTimeFormat(iso=ISO.DATE)
	private Date startDate;
	@NotNull
	@Future
	@DateTimeFormat(iso=ISO.DATE)
	private Date endDate;
	private String comment;
	
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

	public int getConsumerCount() {
		return consumerCount;
	}

	public void setConsumerCount(int consumerCount) {
		this.consumerCount = consumerCount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
