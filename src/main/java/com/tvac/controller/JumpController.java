//package com.tvac.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tvac.common.Msg;
//import com.tvac.service.JumpService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//
//@Api("跳转管理")
//@RequestMapping("jump")
//@RestController
//public class JumpController {
////
////	@Autowired
////	private JumpService jumpService;
//	
////	@PostMapping(value="/insert_jmp")
////	@ApiOperation(value="添加跳转地址")
////	public Msg insert_jmp(@ApiParam(value="学校id") @RequestParam Long school_id,@ApiParam(value="跳转地址") @RequestParam  String jump) {
////		return jumpService.insert_jmp(school_id, jump);
////	}
////	
////	@PutMapping(value="/update_jmp")
////	@ApiOperation(value="更新地址")
////	public Msg update_jmp(@ApiParam(value="学校id") @RequestParam Long school_id,@ApiParam(value="跳转地址") @RequestParam String jump) {
////		return jumpService.update_jmp(school_id, jump);
////	}
////	
////	@GetMapping(value="/select_jump")
////	@ApiOperation(value="查看地址地址")
////	public Msg select_jump(@ApiParam(value="学校id") @RequestParam Long school_id) {
////		return jumpService.select_jump(school_id);
////	}
//}
