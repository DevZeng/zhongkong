package com.tvac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.mapper.ClassMapper;

@Service
public class ClassService {

	@Autowired
	private ClassMapper classMapper;
	
	/*
	 * 添加分类
	 */
	public Msg insert_class(String class_name) {
		return ResultUtil.success(classMapper.insert_class(class_name), "SUCCESS",null);
	}
	
	/*
	 * 删除分类
	 */
	public Msg delete_class(int class_id) {
		return ResultUtil.success(classMapper.delete_class(class_id), "SUCCESS",null);
	}
	
	/*
	 * 查看所有的分类
	 */
	public Msg select_list() {
		return ResultUtil.success(classMapper.select_list(), "SUCCESS",null);
	}
}
