package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.tvac.entriy.Student;

@Mapper
public interface StudentMapper {

	int insert_student(Student student);//添加学生
	
	Student select_student(@Param("stu_number") String stu_number);//用学号查看学生
	
	List<Student> select_user(@Param("user_openid") String user_openid);//用户查看孩子
	
	List<Student> select_user_t(@Param("class_id") int class_id);//教师查看自己班级信息
	
	int update_status1(@Param("stu_number") String stu_number);//通过学生审核
	
	int update_status2(@Param("stu_number") String stu_number);//不通过学生审核
	
	Student select_stu_n(@Param("user_openid") String user_openid,@Param("stu_number") String stu_number);//通过学号和openid查询看孩子信息
	
	int update_images(@Param("stu_images1") String stu_images1,@Param("stu_images2") String stu_images2,
			@Param("stu_images3") String stu_images3,@Param("stu_head") String stu_head,@Param("stu_number") String stu_number);//修改孩子的头像
	
	int delete_student(@Param("stu_number") String stu_number);//删除申请学生的信息
	
	int select_sum(@Param("school_id") Long school_id);//查看孩子的数量
	
	List<Student> select_stu_b(@Param("school_id") Long school_id);//通过学校id产看教师表
//	
//	List<AtSchool> select_atSchool(@Param("user_openid") String user_openid);//教师查看在校学生的信息
//	
//	int update_anzhuo_stu(@Param("stu_number") String stu_number,@Param("stu_images2") String stu_images2);//安卓更新图片
//	
//	List<Student> select_tong();//同步到redis
}
