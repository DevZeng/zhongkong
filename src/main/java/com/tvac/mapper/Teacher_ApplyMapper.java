package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Teacher_Apply;

@Mapper
public interface Teacher_ApplyMapper {

	int insert_teacher_apply(Teacher_Apply tearcher_apply);//添加教师认证
	
	int update_teacher_apply(Teacher_Apply tearcher_apply);//更改教师资料
	
	int delete_teacher_apply(@Param("user_openid") String user_openid);//删除教师的资料
	
	Teacher_Apply select_teacher_apply(@Param("user_openid") String user_openid);//查看教师的资料
	
	List<Teacher_Apply> select_t_all_apply();//查看教师的列表
	
	int update_teacher_status2(@Param("user_openid") String user_openid);//通过教师认证
	
	int update_teacher_status0(@Param("user_openid") String user_openid);//不通过教师认证
	
	int update_teacher_status1(@Param("user_openid") String user_openid);//审核状态
	
	Teacher_Apply select_ban_apply(@Param("user_openid") String user_openid);//查看班主任
	
	Teacher_Apply select_work_number(@Param("work_number") String work_number);//通过教师工号查看教师
	
	Teacher_Apply select_user_t(@Param("user_openid") String user_openid,@Param("work_number") String work_number);//判断教师用户是否存在
	
	int update_t_images(@Param("work_number") String work_number,@Param("user_head2") String user_head2);//更新老师头像
}
