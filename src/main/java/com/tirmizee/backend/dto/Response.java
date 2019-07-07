package com.tirmizee.backend.dto;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = -3231226297137466779L;

	private String msgCode;
	private String msgName;
	private T detail;
	
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public T getDetail() {
		return detail;
	}
	public void setDetail(T detail) {
		this.detail = detail;
	}
	
}
