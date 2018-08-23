package com.tvac.entriy;

import java.io.Serializable;

public class Statistics implements Serializable{

	private Long school_id ;//学校id
	
	private String school_name;//学校的名字
	
	private int user_num;//用户人数
	
	private int teacher_num;//教师人数
	
	private int visitor_num;//访客人数
	
	private double order_totle;//订单总额
	
	private int student_sum;//学生数量

	public int getStudent_sum() {
		return student_sum;
	}

	public void setStudent_sum(int student_sum) {
		this.student_sum = student_sum;
	}

	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	public int getTeacher_num() {
		return teacher_num;
	}

	public void setTeacher_num(int teacher_num) {
		this.teacher_num = teacher_num;
	}

	public int getVisitor_num() {
		return visitor_num;
	}

	public void setVisitor_num(int visitor_num) {
		this.visitor_num = visitor_num;
	}

	public double getOrder_totle() {
		return order_totle;
	}

	public void setOrder_totle(double order_totle) {
		this.order_totle = order_totle;
	}

	
	
}

