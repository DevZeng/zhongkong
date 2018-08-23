package com.tvac.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Order;

@Mapper
public interface ReportMapper {

	Double select_month();//当月的月季
	
	Double select_quarter();//查出一个季度
	
	Double select_year();//查看当年的季度
	
	Double select_s_quarter();//查看上个季度
	
	Double select_week();//查看每周的
	
	List<Order> select_time_o(@Param("start") Date start ,@Param("end") Date end );//根据时间段查看订单
	
	Double select_time_p(@Param("start") Date start ,@Param("end") Date end);//根据时间段查看订单总额
	
	Double select_sch_month(@Param("school_id") Long school_id);//学校当月的月季
	
	Double select_sch_quarter(@Param("school_id") Long school_id);//学校查出一个季度
	
	Double select_sch_year(@Param("school_id") Long school_id);//查看当年的
	
	Double select_sch_s_quarter(@Param("school_id") Long school_id);//查看学校上个季度
	
	Double select_sch_week(@Param("school_id") Long school_id);//查看学校每周的
	
}
