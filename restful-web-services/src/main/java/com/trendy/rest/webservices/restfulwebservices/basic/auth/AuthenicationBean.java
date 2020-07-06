package com.trendy.rest.webservices.restfulwebservices.basic.auth;

public class AuthenicationBean {
	private String message;
	
	public AuthenicationBean(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

		
	
	

}
