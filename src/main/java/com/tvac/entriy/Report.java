package com.tvac.entriy;

import java.io.Serializable;

public class Report implements Serializable{

	private Double month;//当月
	
	private Double quarter;//当前季度
	
	private Double year;//今年
	
	private Double s_quarter;//上个季度
	
	private Double week;//当周
	
	
	public Double getMonth() {
		return month;
	}

	public void setMonth(Double month) {
		this.month = month;
	}

	public Double getQuarter() {
		return quarter;
	}

	public void setQuarter(Double quarter) {
		this.quarter = quarter;
	}

	public Double getYear() {
		return year;
	}

	public void setYear(Double year) {
		this.year = year;
	}

	public Double getS_quarter() {
		return s_quarter;
	}

	public void setS_quarter(Double s_quarter) {
		this.s_quarter = s_quarter;
	}

	public Double getWeek() {
		return week;
	}

	public void setWeek(Double week) {
		this.week = week;
	}
}
