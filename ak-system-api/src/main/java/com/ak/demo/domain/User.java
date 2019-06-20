package com.ak.demo.domain;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
	private String account;
	
	private int id;
	
	private String username;

	private String password;
	
	private int role;
	
	private Date gmtCreate;

	private Date gmtModified;
}
