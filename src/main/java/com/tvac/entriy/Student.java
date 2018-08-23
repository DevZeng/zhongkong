package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author zou
 *
 */
public class Student implements Serializable{
	
	private Long school_id;

	private Long stu_id;
	
	private String user_openid;
	
	private String user_name;
	
	private Long user_iphone;
	
	private String stu_name;
	
	private String stu_sex;
	
	private int  stu_age;
	
	private String stu_number;
	
	private String stu_head;
	
	private String class_grade;
	
	private String class_name;
	
	private int class_id;
	
	private String stu_images1;
	
	private String stu_images2;
	
	private String stu_images3;
	
	private String stu_images_d1;
	
	private String stu_images_d2;
	
	private int stu_status;
	
	private int parent_status;//家长审核信息
	
	private String form_id;
	
	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}

	
	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}

	public int getParent_status() {
		return parent_status;
	}

	public void setParent_status(int parent_status) {
		this.parent_status = parent_status;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date update_time;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updates_time;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creat_time;

	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getUpdates_time() {
		return updates_time;
	}

	public void setUpdates_time(Date updates_time) {
		this.updates_time = updates_time;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getStu_head() {
		return stu_head;
	}

	public void setStu_head(String stu_head) {
		this.stu_head = stu_head;
	}

	public Long getUser_iphone() {
		return user_iphone;
	}

	public void setUser_iphone(Long user_iphone) {
		this.user_iphone = user_iphone;
	}

	public String getStu_images_d1() {
		return stu_images_d1;
	}

	public void setStu_images_d1(String stu_images_d1) {
		this.stu_images_d1 = stu_images_d1;
	}

	public String getStu_images_d2() {
		return stu_images_d2;
	}

	public void setStu_images_d2(String stu_images_d2) {
		this.stu_images_d2 = stu_images_d2;
	}

	public Long getStu_id() {
		return stu_id;
	}

	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}

	public String getUser_openid() {
		return user_openid;
	}

	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public int getStu_age() {
		return stu_age;
	}

	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}

	public String getStu_number() {
		return stu_number;
	}

	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}



	public String getClass_grade() {
		return class_grade;
	}

	public void setClass_grade(String class_grade) {
		this.class_grade = class_grade;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getStu_images1() {
		return stu_images1;
	}

	public void setStu_images1(String stu_images1) {
		this.stu_images1 = stu_images1;
	}

	public String getStu_images2() {
		return stu_images2;
	}

	public void setStu_images2(String stu_images2) {
		this.stu_images2 = stu_images2;
	}

	public String getStu_images3() {
		return stu_images3;
	}

	public void setStu_images3(String stu_images3) {
		this.stu_images3 = stu_images3;
	}

	public int getStu_status() {
		return stu_status;
	}

	public void setStu_status(int stu_status) {
		this.stu_status = stu_status;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
	
	
}
