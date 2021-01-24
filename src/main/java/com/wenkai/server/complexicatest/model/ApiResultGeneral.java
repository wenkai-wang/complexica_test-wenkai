package com.wenkai.server.complexicatest.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value="apiResultGenModel")
public class ApiResultGeneral<T> {

	private int code;
	private String message;
	private int listCount;
	private List<T> listGeneral;
	private String country;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public List<T> getListGeneral() {
		return listGeneral;
	}
	public void setListGeneral(List<T> listGeneral) {
		this.listGeneral = listGeneral;
	}
	
	
	
}
