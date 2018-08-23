package com.tvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.service.ApkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("安卓机子管理")
public class ApkController {

	@Autowired
	private ApkService apkService;
	
	@ApiOperation(value="添加主分类")
	@PostMapping(value="/insert_main")
	public Msg insert_main(@ApiParam(value="主分类名称") @RequestParam String main_name) {
		return apkService.insert_main(main_name);
	}
	
	@GetMapping(value="/select_main")
	@ApiOperation(value="查看一级分类 ")
	public Msg select_main() {
		return apkService.select_main();
	}
	
	@ApiOperation(value="添加二级分类")
	@PostMapping(value="/insert_two")
	public Msg insert_two(@ApiParam(value="一级分类id") @RequestParam int id,@ApiParam(value="二级分类名称") @RequestParam String two_name) {
		return apkService.insert_two(id, two_name);
	}
	
	@GetMapping(value="/select_two")
	@ApiOperation(value="添加查看二级分类 ")
	public Msg select_two(@ApiParam(value="一级分类id") @RequestParam int id) {
		return apkService.select_two(id);
	}
	
	@ApiOperation(value="添加apk")
	@PostMapping(value="/insert_apk")
	public Msg insert_apk(@ApiParam(value="二级分类id") @RequestParam int two_id,@ApiParam(value="apk地址") @RequestParam String apk_address,
			@ApiParam(value="学校域名") @RequestParam String domain_name,@ApiParam(value="apk版本号") @RequestParam String apk_edition) {
		return apkService.insert_apk(two_id, apk_address, domain_name, apk_edition);
	}
	
	@ApiOperation(value="修改apk")
	@PutMapping(value="/update_apk")
	public Msg update_apk(@ApiParam(value="apk地址") @RequestParam String apk_address,@ApiParam(value="学校域名") @RequestParam String domain_name,
			@ApiParam(value="apk版本号") @RequestParam String apk_edition,@ApiParam(value="apk_id") @RequestParam int id) {
		return apkService.update_apk(apk_address, domain_name, apk_edition,id);
	}
	
	@GetMapping(value="/select_apk")
	@ApiOperation(value="查看apk")
	public Msg select_apk(@ApiParam(value="二级分类id") @RequestParam int two_id) {
		return apkService.select_apk(two_id);
	}
	
	@GetMapping(value="/select_all_apk")
	@ApiOperation(value="查看所有apk")
	public Msg select_all_apk() {
		return apkService.select_all_apk();
	}
}
