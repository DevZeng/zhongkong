package com.tvac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.entriy.Jump;
import com.tvac.entriy.School;
import com.tvac.mapper.JumpMapper;
import com.tvac.mapper.SchoolMapper;

@Service
public class JumpService {

	@Autowired
	private JumpMapper jumpMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	
	/*
	 * 选择跳转地址
	 */
	public Msg insert_jmp(Long school_id,String jump) {
		School select_d_school=schoolMapper.select_d_school(school_id);
		Jump select_jump=jumpMapper.select_jump(school_id);
		if(select_jump==null)
		return ResultUtil.success(jumpMapper.insert_jmp(school_id, select_d_school.getSchool_name(), jump), "SUCCESS", null);
		else
		return ResultUtil.error(0, "已添加");
	}
	
	/*
	 * 更新地址
	 */
	public Msg update_jmp(Long school_id,String jump) {
		return ResultUtil.success(jumpMapper.update_jmp(jump, school_id), "SUCCESS", null);
	}
	
	/*
	 * 查看地址地址
	 */
	public Msg select_jump(Long school_id) {
		return ResultUtil.success(jumpMapper.select_jump(school_id), "SUCCESS", null);
	}
}
