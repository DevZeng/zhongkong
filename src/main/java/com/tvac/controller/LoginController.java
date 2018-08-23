package com.tvac.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.entriy.Login;
import com.tvac.service.ShiroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("登录管理")
@RequestMapping("login")
@RestController
public class LoginController {

	@Autowired
	private ShiroService shiroService;
	
	@PostMapping(value="/getPasswordByUsername")
	@ApiOperation(value="登录")
	public Msg getPasswordByUsername(@RequestParam Long username,@RequestParam String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return shiroService.getPasswordByUsername(username, password);
	}
	
	@PostMapping(value="/insert_login")
	@ApiOperation(value="添加登录")
//	@RequiresRoles(logical = Logical.OR, value = {"user"})
    public Msg  insert_login(@RequestBody Login login) throws UnsupportedEncodingException {
    	return shiroService.insert_login(login);
    }
	
	@DeleteMapping(value="/delete_login/{id}")
	@ApiOperation(value="删除登录")
//	@RequiresRoles(logical = Logical.OR, value = {"user"})
    public Msg  delete_login(@PathVariable int id) {
		return shiroService.delete_login(id);
    }
	
	@GetMapping(value="/select_all_login")
	@ApiOperation(value="查看所有的账号")
//	@RequiresRoles(logical = Logical.OR, value = {"user"})
    public Msg select_all_login() {
		return shiroService.select_all_login();
				
    }
}
