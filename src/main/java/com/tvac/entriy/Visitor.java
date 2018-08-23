package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Visitor implements Serializable {
	
	
	private Long school_id;



	private int visitor_id;
	
	private String user_openid;
	
	private String user_name;
	
	private Long user_iphone;
	
	private String visitor_head1;
	
	private String visitor_head2;
	
	private int visitor_time;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date vistor_times;
	
	private String visitor_butt;
	
	private String visitor_reason;
	
	private int vistior_status;
	
	private String form_id;
	
	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}

	public Date getVistor_times() {
		return vistor_times;
	}

	public void setVistor_times(Date vistor_times) {
		this.vistor_times = vistor_times;
	}

	public int getVistior_status() {
		return vistior_status;
	}

	public void setVistior_status(int vistior_status) {
		this.vistior_status = vistior_status;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creatime;

	public int getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(int visitor_id) {
		this.visitor_id = visitor_id;
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

	public Long getUser_iphone() {
		return user_iphone;
	}

	public void setUser_iphone(Long user_iphone) {
		this.user_iphone = user_iphone;
	}

	public String getVisitor_head1() {
		return visitor_head1;
	}

	public void setVisitor_head1(String visitor_head1) {
		this.visitor_head1 = visitor_head1;
	}

	public String getVisitor_head2() {
		return visitor_head2;
	}

	public void setVisitor_head2(String visitor_head2) {
		this.visitor_head2 = visitor_head2;
	}

	public int getVisitor_time() {
		return visitor_time;
	}

	public void setVisitor_time(int visitor_time) {
		this.visitor_time = visitor_time;
	}

	public String getVisitor_butt() {
		return visitor_butt;
	}

	public void setVisitor_butt(String visitor_butt) {
		this.visitor_butt = visitor_butt;
	}

	public String getVisitor_reason() {
		return visitor_reason;
	}

	public void setVisitor_reason(String visitor_reason) {
		this.visitor_reason = visitor_reason;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}
	
	
}
