package com.tvac.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tvac.common.RedisCacheUtil;
import com.tvac.entriy.Order;
import com.tvac.entriy.School;
import com.tvac.entriy.Student;
import com.tvac.entriy.Teacher_Apply;
import com.tvac.entriy.User;
import com.tvac.entriy.Visitor;
import com.tvac.mapper.OrderMapper;
import com.tvac.mapper.SchoolMapper;
import com.tvac.mapper.StudentMapper;
import com.tvac.mapper.Teacher_ApplyMapper;
import com.tvac.mapper.UserMapper;
import com.tvac.mapper.VisitorMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
    public RedisTemplate<String, ?> redisTemplate;
	@Autowired
	private RedisCacheUtil<?> redisCacheUtil;
	@Autowired
	private Teacher_ApplyMapper teacher_ApplyMapper;
	@Autowired
	private VisitorMapper visitorMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	public int inser_user(Long school_id) {
		
		School select_d_school=schoolMapper.select_d_school(school_id);
		
		synchro_user(select_d_school.getSchool_user());
		
		synchro_student(select_d_school.getSchool_student());
		
		synchro_vistor(select_d_school.getSchool_visitor());
		
		sychro_order(select_d_school.getSchool_order());
		
		return 1;
	}
	
	/*
	 * 添加用户表
	 * 
	 */
	@Async
	public void synchro_user(String school_user) {
		String[] school_id=school_user.split("_");	
		String key=school_user;
		if(redisTemplate.hasKey(key)) {
			List<User> list_user=redisCacheUtil.getCacheList(key);
			for(User user:list_user) {
				User select_user=userMapper.select_user(user.getUser_openid());
				if(select_user==null) {
					user.setSchool_id(Long.valueOf(school_id[0]));
					userMapper.insert_user(user);
				}
			}
		}
	}
	
	/*
	 * 同步学生表
	 */
	@Async
	public void synchro_student(String school_student) {
		String[] school_id=school_student.split("_");
		String key=school_student;
		if(redisTemplate.hasKey(key)) {
			List<Student> list_stduent=redisCacheUtil.getCacheList(key);
//			System.out.println(list_stduent.size());
			for (Student student : list_stduent) {
				Student select_student=studentMapper.select_student(student.getStu_number());
				if(select_student==null) {
				student.setSchool_id(Long.valueOf(school_id[0]));
					studentMapper.insert_student(student);
				}
			}
		}
	}
	
	/*
	 * 同步访客表
	 */
	@Async
	public void synchro_vistor(String school_visitor) {
		String[] school_id=school_visitor.split("_");
		String key=school_visitor;
		if(redisTemplate.hasKey(key)) {
			List<Visitor> select_all_visitor=redisCacheUtil.getCacheList(key);
			for(Visitor visitor:select_all_visitor) {
				Visitor select_u_cz=visitorMapper.select_user(visitor.getUser_openid());
				if(select_u_cz==null) {
					visitor.setSchool_id(Long.valueOf(school_id[0]));
					visitorMapper.insert_vistor(visitor);
				}
			}
		}
	}
	
	/*
	 * 同步订单
	 */
	@Async
	public void sychro_order(String school_order) {
		String[] order_id=school_order.split("_");
		String key=school_order;
		if(redisTemplate.hasKey(key)) {
			List<Order> select_order=redisCacheUtil.getCacheList(key);
			for(Order order:select_order) {
				Order select_d_order=orderMapper.select_order(order.getOrder_id());
				if(select_d_order==null) {
					order.setSchool_id(Long.valueOf(order_id[0]));
					orderMapper.insert_order(order);
				}
			}
		}
	}
}
