package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * zou
 */

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long school_id;
	
	private Long user_id;
	
	private String user_openid;
	
	private String user_image;
	
	private String user_alias;
	
	private String user_name;
	
	private String user_sex;
	
	private Long user_iphone;
	
	private String user_mail;
	
	private int user_age;
	
	private String user_card;
	
	private String user_address;
	
	private String user_word;
	
	private int whether;
	
	private int teacher;
	
	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public int getWhether() {
		return whether;
	}

	public void setWhether(int whether) {
		this.whether = whether;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creat_time;
	public String getUser_mail() {
		return user_mail;
	}

	
	
	public Long getSchool_id() {
		return school_id;
	}



	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}



	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_openid() {
		return user_openid;
	}

	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_alias() {
		return user_alias;
	}

	public void setUser_alias(String user_alias) {
		this.user_alias = user_alias;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Long getUser_iphone() {
		return user_iphone;
	}

	public void setUser_iphone(Long user_iphone) {
		this.user_iphone = user_iphone;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_card() {
		return user_card;
	}

	public void setUser_card(String user_card) {
		this.user_card = user_card;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_word() {
		return user_word;
	}

	public void setUser_word(String user_word) {
		this.user_word = user_word;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
	
	
}
