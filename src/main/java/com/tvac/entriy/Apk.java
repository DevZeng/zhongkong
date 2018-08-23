package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author zou
 *
 */
public class Apk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int two_id;
	
	private String apk_address;
	
	private String domain_name;
	
	private String apk_edition;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creatime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date upatetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTwo_id() {
		return two_id;
	}

	public void setTwo_id(int two_id) {
		this.two_id = two_id;
	}

	public String getApk_address() {
		return apk_address;
	}

	public void setApk_address(String apk_address) {
		this.apk_address = apk_address;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public String getApk_edition() {
		return apk_edition;
	}

	public void setApk_edition(String apk_edition) {
		this.apk_edition = apk_edition;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public Date getUpatetime() {
		return upatetime;
	}

	public void setUpatetime(Date upatetime) {
		this.upatetime = upatetime;
	}
	
	
}
