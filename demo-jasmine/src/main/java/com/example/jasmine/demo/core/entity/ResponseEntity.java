package com.example.jasmine.demo.core.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

public class ResponseEntity implements Serializable {

	public ResponseEntity() {

	}

	public ResponseEntity(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResponseEntity(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private Integer code = 1;

	private String msg;

	private Object data;
	/*
	 * 相应时间
	 */
	private Date respTime;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public <T> T getData() {
		return (T) data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		return JSON.toJSONString(this);
	}

	public Date getRespTime() {
		return respTime;
	}

	public void setRespTime(Date respTime) {
		this.respTime = respTime;
	}
}
