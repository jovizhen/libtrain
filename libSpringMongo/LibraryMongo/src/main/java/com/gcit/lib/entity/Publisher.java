package com.gcit.lib.entity;

import org.springframework.data.annotation.Id;

public class Publisher {

	@Id
	private String id;
	
	private String name;
	private String address;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String publisherId) {
		this.id = publisherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
