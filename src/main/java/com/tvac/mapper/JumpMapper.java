package com.tvac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Jump;

@Mapper
public interface JumpMapper {

	int insert_jmp(@Param("school_id") Long school_id,@Param("school_name") String school_name,@Param("jump") String jump);//选择跳转地址
	
	int update_jmp(@Param("jump") String jump,@Param("school_id") Long school_id);//更新地址
	
	Jump select_jump(@Param("school_id") Long school_id);//查看地址地址
}
