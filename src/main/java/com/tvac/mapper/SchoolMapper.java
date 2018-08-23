package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.School;

@Mapper
public interface SchoolMapper {

	int insert_school(@Param("school_id") Long school_id,@Param("class_id") int class_id,@Param("school_name") String school_name,@Param("school_user") String school_user,
			@Param("school_student") String school_student,@Param("school_visitor") String school_visitor,@Param("school_order") String school_order,
			@Param("domain_name") String domain_name,@Param("jump") String jump);//添加学校
	
	List<School> select_school();//查看所有的学校
	
	School select_d_school(@Param("school_id") Long school_id);//查看单个学校
	
	List<School> select_class_school(@Param("class_id") int class_id);//查看所有的学校
	
	int update_school(@Param("school_id") Long school_id,@Param("school_name") String school_name,@Param("domain_name") String domain_name,@Param("jump") String jump);//修改学校信息
} 
