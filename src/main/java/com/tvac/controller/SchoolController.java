package com.tvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("学校管理")
@RequestMapping("school")
@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping(value="/insert_school")
	@ApiOperation(value="添加学校")
//	@ApiImplicitParams(value = { @ApiImplicitParam( name="school_id",value="学校id")})
	public Msg insert_school(@ApiParam(value="学校id") @RequestParam Long school_id,@ApiParam(value="学校名称") @RequestParam String school_name,@ApiParam(value="分类id") @RequestParam int class_id
			,@ApiParam(value="学校域名") @RequestParam String domain_name,@ApiParam(value="跳转地址") @RequestParam String jump) {
		return schoolService.insert_school(school_id, school_name,class_id,domain_name,jump);
	}
	
	@GetMapping(value="/select_school")
	@ApiOperation(value="查看学校")
	public Msg select_school(@ApiParam(value="页码") @RequestParam int start){
		return schoolService.select_school(start);
	}
	
	@GetMapping(value="/select_statistics")
	@ApiOperation(value="查看每个学校的报表分析")
	public Msg select_statistics() {
		return schoolService.select_statistics();
	}
	
	@GetMapping(value="/select_class_school")
	@ApiOperation(value="通过分类查询学校")
	public  Msg select_class_school(@ApiParam(value="分类id") @RequestParam int class_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_class_school(class_id,start);
	}
	
	@GetMapping(value="/select_user_b")
	@ApiOperation(value="根据学校id查看用户")
	public Msg select_user_b(@RequestParam Long school_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_user_b(school_id,start);
	}
	
	@GetMapping(value="/select_tea_b")
	@ApiOperation(value="根据学校id查看教师")
	public Msg select_tea_b(@RequestParam Long school_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_tea_b(school_id,start);
	}
	
	@GetMapping(value="/select_stu_b")
	@ApiOperation(value="通过学校id查看学生表")
	public Msg select_stu_b(@RequestParam Long school_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_stu_b(school_id,start);
	}
	
	@GetMapping(value="/select_vis_b")
	@ApiOperation(value="根据学校id查看访客")
	public Msg select_vis_b(@RequestParam Long school_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_vis_b(school_id,start);
	}
	
	@GetMapping(value="/select_ord_b")
	@ApiOperation(value="根据订单查看订单")
	public Msg select_ord_b(@RequestParam Long school_id,@ApiParam(value="页码") @RequestParam int start) {
		return schoolService.select_ord_b(school_id,start);
	}
	
	@GetMapping(value="/select_ord_sum")
	@ApiOperation(value="查看总订单的额度 ")
	public Msg select_ord_sum() {
		return schoolService.select_ord_sum();
	}
	
	@GetMapping(value="/school_sum")
	@ApiOperation(value="查看各学校的(人.教.学生.访)总额 ")
	public Msg school_sum(@RequestParam Long school_id,@ApiParam(value="a:1=用户,2=教师,3=访客,4=学生") @RequestParam int a) {
		return schoolService.school_sum(school_id,a);
	}
	
	@GetMapping(value="/select_all_order")
	@ApiOperation(value="查看所有的订单")
	public Msg select_all_order(@RequestParam int start) {
		return schoolService.select_all_order(start);
	}
	
	@PutMapping(value="/update_school")
	@ApiOperation(value="修改学校信息")
	public Msg update_school(@RequestParam Long school_id,@RequestParam String school_name,@RequestParam String domain_name,@ApiParam(value="跳转地址") @RequestParam String jump) {
		return schoolService.update_school(school_id, school_name, domain_name,jump);
	}
	
	@GetMapping(value="/select_d_school")
	@ApiOperation(value="根据学校id查看学校")
	public Msg select_d_school(@RequestParam Long school_id) {
		return schoolService.select_d_school(school_id);
	}
}
