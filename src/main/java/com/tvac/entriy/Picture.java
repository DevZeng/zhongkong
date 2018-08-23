package com.tvac.entriy;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable{

	private int picture_id;
	
	private int version_id;
	
	private String version_name;
	
	private int colour_id;
	
	private String colour;
	
	private String picture;
	
	private Date creatime;

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}

	public String getVersion_name() {
		return version_name;
	}

	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}

	public int getColour_id() {
		return colour_id;
	}

	public void setColour_id(int colour_id) {
		this.colour_id = colour_id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
}
