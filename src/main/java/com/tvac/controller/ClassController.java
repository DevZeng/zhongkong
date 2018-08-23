package com.tvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.service.ClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("分类管理")
@RestController
@RequestMapping(value="class")
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@PostMapping(value="/insert_class")
	@ApiOperation(value="添加分类")
	public Msg insert_class(@ApiParam(value="分类名称") @RequestParam String class_name) {
		return classService.insert_class(class_name);
	}
	
	@DeleteMapping(value="/delete_class/{class_id}")
	@ApiOperation(value="删除分类")
	public Msg delete_class(@ApiParam(value="分类id") @PathVariable int class_id) {
		return classService.delete_class(class_id);
	}
	
	@GetMapping(value="/select_list")
	@ApiOperation(value="查看所有的分类")
	public Msg select_list() {
		return classService.select_list();
	}
}
