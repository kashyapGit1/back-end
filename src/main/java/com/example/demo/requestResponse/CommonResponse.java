package com.example.demo.requestResponse;

public class CommonResponse {

	private Integer status;
	private String message;
	private Object response;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public CommonResponse(Integer status, String message, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}
	
	

}
