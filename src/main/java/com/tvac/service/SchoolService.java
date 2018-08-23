package com.tvac.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tvac.common.AllResult;
import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.entriy.Order;
import com.tvac.entriy.School;
import com.tvac.entriy.Statistics;
import com.tvac.entriy.Student;
import com.tvac.entriy.User;
import com.tvac.entriy.Visitor;
import com.tvac.mapper.OrderMapper;
import com.tvac.mapper.SchoolMapper;
import com.tvac.mapper.StudentMapper;
import com.tvac.mapper.UserMapper;
import com.tvac.mapper.VisitorMapper;

@Service
public class SchoolService {

	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private VisitorMapper visitorMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	/*
	 * 添加学校
	 */
	public Msg insert_school(Long school_id,String school_name,int class_id,String domain_name,String jump) {
		School select_d_school=schoolMapper.select_d_school(school_id);
		if(select_d_school==null) {
			int insert_school=schoolMapper.insert_school(school_id, class_id,school_name, school_id+"_user", school_id+"_student", school_id+"_visitor",school_id+"_order",domain_name,jump);
			if(insert_school==1)
				return ResultUtil.success(1, "SUCCESS",null);
			else {
				return ResultUtil.error(0, "添加失败!");
			}
		}else {
			return ResultUtil.error(0, "已已经添加了!");
		}
	}
	
	/*
	 * 查看所有的学校
	 */
	public Msg select_school(int start){
		PageHelper.startPage(start, 10);
		List<School> select_school=schoolMapper.select_school();
		Page<School> school=(Page<School>)select_school;
		return ResultUtil.success(school, "SUCCESS", String.valueOf(school.getTotal()));
	}
	
	/*
	 * 查看每个学校的报表分析
	 */
	public Msg select_statistics() {
		List<School> select_school=schoolMapper.select_school();
		List<Statistics> statistics=new ArrayList<>();

		for(School school:select_school) {
			Statistics stitc=new Statistics();
			int select_sum=userMapper.select_sum(school.getSchool_id());
			int select_t_sum=userMapper.select_t_sum(school.getSchool_id());
			int select_sum1=visitorMapper.select_sum(school.getSchool_id());
			int select_sum2=studentMapper.select_sum(school.getSchool_id());
			Double select_num=orderMapper.select_num(school.getSchool_id());
			if(select_num==null)
				select_num=(double) 0;
			BigDecimal b = new BigDecimal(select_num);
			select_num = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//小数点2位
			
			stitc.setSchool_id(school.getSchool_id());
			stitc.setSchool_name(school.getSchool_name());
			stitc.setTeacher_num(select_t_sum);
			stitc.setUser_num(select_sum);
			stitc.setVisitor_num(select_sum1);
			stitc.setOrder_totle(select_num);
			stitc.setStudent_sum(select_sum2);
			statistics.add(stitc);
		}
		return ResultUtil.success(statistics, "SUCCESS",null);
	}
	
	/*
	 * 查看各学校的总额
	 */
	public Msg school_sum(Long school_id,int a) {
//		System.out.println(userMapper.select_sum(school_id));
		int num=0;
		switch(a){
		case 1:
			num=userMapper.select_sum(school_id);
			break;
		case 2:
			num=userMapper.select_t_sum(school_id);
			break;
		case 3:
			num=visitorMapper.select_sum(school_id);
			break;
		case 4:
			num=studentMapper.select_sum(school_id);
			break;
		}
		return ResultUtil.success(num,"SUCCESS","0");
	}
	
	/*
	 * 通过分类查看学校
	 */
	public  Msg select_class_school(int class_id,int start) {
		PageHelper.startPage(start, 10);
		List<School> select_class_school=schoolMapper.select_class_school(class_id);
		Page<School> select_school=(Page<School>)select_class_school;
		return ResultUtil.success(	select_school,"SUCCESS", String.valueOf(select_school.getTotal()));
	}
	
	/*
	 * 查看所有的订单
	 */
	public Msg select_all_order(int start) {
		PageHelper.startPage(start, 10);
		List<Order> select_all_order=orderMapper.select_all_order();
		Page<Order> list_order=(Page<Order>)select_all_order;
		return ResultUtil.success(list_order,"SUCCESS",String.valueOf(list_order.getTotal()));
	}
	
	/*
	 * 根据学校id查看用户
	 */
	public Msg select_user_b(Long school_id,int start) {
		PageHelper.startPage(start, 10);
		List<User>  select_user_b=userMapper.select_user_b(school_id);
		Page<User> select_user=(Page<User>)select_user_b;
		return ResultUtil.success(select_user,"SUCCESS", String.valueOf(select_user.getTotal()));
	}
	
	/*
	 * 根据学校id查看教师
	 */
	public Msg select_tea_b(Long school_id,int start) {
		PageHelper.startPage(start, 10);
		List<User> select_tea_b=userMapper.select_tea_b(school_id);
		Page<User> select_tearch=(Page<User>)select_tea_b;
		return ResultUtil.success(select_tearch,"SUCCESS",String.valueOf(select_tearch.getTotal()));
	}
	
	/*
	 * 通过学校id产看教师表
	 */
	public Msg select_stu_b(Long school_id,int start) {
		PageHelper.startPage(start, 10);
		List<Student> select_stu_b=studentMapper.select_stu_b(school_id);
		Page<Student> select_student=(Page<Student>)select_stu_b;
		return ResultUtil.success(select_student,"SUCCESS", String.valueOf(select_student.getTotal()));
	}
	
	/*
	 * 根据学校id查看访客
	 */
	public Msg select_vis_b(Long school_id,int start) {
		PageHelper.startPage(start, 10);
		List<Visitor> select_vis_b=visitorMapper.select_vis_b(school_id);
		Page<Visitor> select_vistor=(Page<Visitor>)select_vis_b;
		return ResultUtil.success(select_vistor,"SUCCESS", String.valueOf(select_vistor.getTotal()));
	}
	
	/*
	 * 根据订单查看订单
	 */
	public Msg select_ord_b(Long school_id,int start) {
		PageHelper.startPage(start, 10);
		List<Order> select_ord_b=orderMapper.select_ord_b(school_id);
		Page<Order> select_order=(Page<Order>)select_ord_b;
		return ResultUtil.success(select_order,"SUCCESS", String.valueOf(select_order.getTotal()));
	}
	
	/*
	 *查看总订单的额度 
	 */
	public Msg select_ord_sum() {
		Double select_ord_sum=orderMapper.select_ord_sum();
		if(select_ord_sum==null) {
			select_ord_sum=(double) 0;
		}
		BigDecimal b = new BigDecimal(select_ord_sum);
		select_ord_sum = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return ResultUtil.success(select_ord_sum, "SUCCESS",null);
	}
	
	/*
	 * 修改学校信息
	 */
	public Msg update_school(Long school_id,String school_name,String domain_name,String jump) {
		return ResultUtil.success(schoolMapper.update_school(school_id, school_name, domain_name,jump), "SUCCESS", null);
	}
	
	/*
	 * 根据学校id查看学校
	 */
	public Msg select_d_school(Long school_id) {
		return ResultUtil.success(schoolMapper.select_d_school(school_id), "SUCCESS", null);
	}
}
