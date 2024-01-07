package org.java.mql.reponse;

import org.springframework.http.HttpStatus;

public class ErrorReponse {
    private HttpStatus httpStatus;
    private String msg;
    
     public ErrorReponse() {
    	
    }

	public ErrorReponse(HttpStatus httpStatus, String msg) {
		super();
		this.httpStatus = httpStatus;
		this.msg = msg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    
}
