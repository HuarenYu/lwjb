package com.lwjb.tour.vos;



public class JsonResponse<T> {
	
	private int statusCode;
	private String statusMsg;
	private T data;
	
	public static final int SUCCESS = 200;
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusMsg() {
		return statusMsg;
	}
	
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
