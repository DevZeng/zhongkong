package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author zou
 *
 */
public class TwoClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int two_id;
	
	private int id;
	
	private String two_name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creatime;

	public int getTwo_id() {
		return two_id;
	}

	public void setTwo_id(int two_id) {
		this.two_id = two_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwo_name() {
		return two_name;
	}

	public void setTwo_name(String two_name) {
		this.two_name = two_name;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	
	
}
