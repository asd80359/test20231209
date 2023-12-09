package com.example.demo.vo;

import lombok.Data;

@Data
public class member {
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public member(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	private Integer id;
	private String name;
	private String username;
	private String password;
}
