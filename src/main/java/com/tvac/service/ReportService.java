package com.tvac.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.entriy.Order;
import com.tvac.entriy.Report;
import com.tvac.mapper.ReportMapper;

@Service
public class ReportService {

	@Autowired
	private ReportMapper reportMapper;
	
	/*
	 * 总控总结报表
	 */
	public Msg select_report() {
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
		Report report=new Report();
		if(reportMapper.select_month()!=null)
		report.setMonth(Double.valueOf(df.format(reportMapper.select_month())));
		else
			report.setMonth((double) 0);
		if(reportMapper.select_quarter()!=null)
		report.setQuarter(Double.valueOf(df.format(reportMapper.select_quarter())));
		else
			report.setQuarter((double) 0);
		if(reportMapper.select_year()!=null)
		report.setYear(Double.valueOf(df.format(reportMapper.select_year())));
		else
			report.setYear((double) 0);
		if(reportMapper.select_s_quarter()!=null) 
		report.setS_quarter(Double.valueOf(df.format(reportMapper.select_s_quarter())));
		else
			report.setS_quarter((double) 0);
		if(reportMapper.select_week()!=null) 
		report.setWeek(Double.valueOf(df.format(reportMapper.select_week())));
		else
			report.setWeek((double) 0);
		return ResultUtil.success(report, "SUCCESS",String.valueOf(0));
	}
	
	/*
	 * 根据时间段查看订单情况和总额
	 */
	public Msg select_time_o(String start_time,String end_time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start=formatter.parse(start_time);
			Date end=formatter.parse(end_time);
			Double select_time_p=reportMapper.select_time_p(start, end);
			String totle;
			if(select_time_p!=null) {
				java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
				totle=df.format(select_time_p);
			}else {
				totle=String.valueOf(0);
			}
				return ResultUtil.success(reportMapper.select_time_o(start, end),"SUCCESS", totle);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return null;		
		}
	}
	
	public Msg school_report(Long school_id) {
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
		Report report=new Report();
		if(reportMapper.select_sch_month(school_id)!=null)
			report.setMonth(Double.valueOf(df.format(reportMapper.select_sch_month(school_id))));
			else
				report.setMonth((double) 0);
			if(reportMapper.select_sch_quarter(school_id)!=null)
			report.setQuarter(Double.valueOf(df.format(reportMapper.select_sch_quarter(school_id))));
			else
				report.setQuarter((double) 0);
			if(reportMapper.select_sch_year(school_id)!=null)
			report.setYear(Double.valueOf(df.format(reportMapper.select_sch_year(school_id))));
			else
				report.setYear((double) 0);
			if(reportMapper.select_sch_s_quarter(school_id)!=null)
				report.setS_quarter(Double.valueOf(df.format(reportMapper.select_sch_s_quarter(school_id))));
			else
				report.setS_quarter((double) 0);
			if(reportMapper.select_sch_week(school_id)!=null)
				report.setWeek(Double.valueOf(df.format(reportMapper.select_sch_week(school_id))));
			else
				report.setWeek((double) 0);
			return ResultUtil.success(report, "SUCCESS",String.valueOf(0));
	}

}
