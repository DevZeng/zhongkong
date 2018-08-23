package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

public class Classif implements Serializable{

	private int class_id;
	
	private String class_name;
	
	private Date creatime;

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	
}
