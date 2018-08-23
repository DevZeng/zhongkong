package com.tvac.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.User;

@Mapper
public interface UserMapper {

	int insert_user(User user);//用户注册
	
	int update_user(User user);//用户修改
	
	User select_user(@Param("user_openid") String user_openid);//查看用户
	
	List<User> select_all_user();//查看所有的用户
	
	int update_teacher(@Param("user_openid") String user_openid);//改变了老师的状态

	int select_sum(@Param("school_id") Long school_id);//查看用户的数量
	
	int select_t_sum(@Param("school_id") Long school_id);//查看教师人数
	
	List<User> select_user_b(@Param("school_id") Long school_id);//根据学校id查看用户
	
	List<User> select_tea_b(@Param("school_id") Long school_id);//根据学校id查看教师

}
