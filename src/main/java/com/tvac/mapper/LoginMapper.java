package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Login;

@Mapper
public interface LoginMapper {

	int insert_login(Login login);//添加登录
	
	int delete_login(@Param("id") int id);//删除账号
	
	Login select_login(@Param("user_iphone") Long user_iphone);//用账号查看
	
	List<Login> select_all_login();//查看所有的账号
	
	String get_role(@Param("user_iphone") Long user_iphone);//查看权限
}
