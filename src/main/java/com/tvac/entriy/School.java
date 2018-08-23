package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class School implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private Long school_id;
	
	private String school_name;
	
	private String school_user;
	
	private String school_student;
	
	private String school_visitor;
	
	private String school_order;
	
	private String domain_name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creatime;	

	private String jump;
	
	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public String getSchool_order() {
		return school_order;
	}

	public void setSchool_order(String school_order) {
		this.school_order = school_order;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSchool_user() {
		return school_user;
	}

	public void setSchool_user(String school_user) {
		this.school_user = school_user;
	}

	public String getSchool_student() {
		return school_student;
	}

	public void setSchool_student(String school_student) {
		this.school_student = school_student;
	}

	public String getSchool_visitor() {
		return school_visitor;
	}

	public void setSchool_visitor(String school_visitor) {
		this.school_visitor = school_visitor;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	
}


