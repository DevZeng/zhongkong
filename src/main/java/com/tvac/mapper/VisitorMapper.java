package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Visitor;

@Mapper
public interface VisitorMapper {

	int insert_vistor(Visitor visitor);//添加访客申请
	
	int vistior_status1(@Param("visitor_id") int visitor_id);//申请成功
	
	int vistior_status2(@Param("visitor_id") int visitor_id);//申请不成功
	
	int vistior_status3(@Param("visitor_id") int visitor_id);//申请不成功
	
	Visitor select_d_visitor(@Param("visitor_id") int visitor_id);//查看单个申请
	
	List<Visitor> select_all_visitor();//查看所有的申请
	
	List<Visitor> select_u_visitor(@Param("user_openid") String user_openid);//用户查看申请记录
	
	Visitor select_u_cz(@Param("user_openid") String user_openid);//查看客户有申请的有效期
	
	Visitor select_user(@Param("user_openid") String user_openid);//查看客户
	
	int select_sum(@Param("school_id") Long school_id);//查看访客人数
	
	List<Visitor> select_vis_b(@Param("school_id") Long school_id);//根据学校id查看访客
}
