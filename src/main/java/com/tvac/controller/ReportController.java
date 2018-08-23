package com.tvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.Msg;
import com.tvac.service.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("报表管理")
@RequestMapping("report")
@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping(value="/select_report")
	@ApiOperation(value="总控总结报表")
	public Msg select_report() {
		return reportService.select_report();
	}
	
	@GetMapping(value="/select_time_o")
	@ApiOperation(value="根据时间段查看订单情况和(注意:返回的总额=msg)")
	public Msg select_time_o(@ApiParam(value="开始时间-格式-(2018-07-16 17:47:43)") @RequestParam String start_time,@ApiParam(value="末时间-格式-(2018-07-16 17:47:43)") @RequestParam  String end_time) {
		return reportService.select_time_o(start_time, end_time);
	}
	
	@GetMapping(value="/school_report")
	@ApiOperation(value="根据学校id查看报表")
	public Msg school_report(@ApiParam(value="学校id") @RequestParam Long school_id) {
		return reportService.school_report(school_id);
	}
}
