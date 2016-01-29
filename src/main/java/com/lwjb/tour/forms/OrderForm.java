package com.lwjb.tour.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderForm {
	
	@NotNull
	@Size(min = 1, max = 20)
	private String consumerName;
	@NotNull
	@Size(min = 6, max = 16)
	private String consumerPhone;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
