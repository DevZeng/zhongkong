package com.tvac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("学校导入管理")
@RequestMapping("dao")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/inser_user")
	@ApiOperation(value="导入数据库")
	public Msg inser_user(@RequestParam Long school_id) {
		int result=userService.inser_user(school_id);
		if(result!=1)
			ResultUtil.error(0, "错误了");
		return ResultUtil.success(1, "SUCCESS",null);
	}
}
