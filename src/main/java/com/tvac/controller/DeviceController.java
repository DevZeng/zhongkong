package com.tvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvac.common.AllResult;
import com.tvac.common.Msg;
import com.tvac.common.Result;
import com.tvac.common.Results;
import com.tvac.entriy.DeviceAdd;
import com.tvac.service.DeviceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("设备管理")
@RestController
@RequestMapping(value="device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	
	@PostMapping(value="/select_dev")
	@ApiOperation("绑定设备")
	public Msg select_dev(@RequestParam Long device_id) {
		return deviceService.select_dev(device_id);
	}
	
	@PostMapping(value="/update_status0")
	@ApiOperation("解绑")
	public Msg update_status0(@RequestParam Long device_id) {
		return deviceService.update_status0(device_id);
	}
	
	@PostMapping(value="/insert_version")
	@ApiOperation("添加设备型号")
	public Results insert_version(@RequestParam String version_name,@RequestParam(required=false) String remarks,@RequestParam(required=false) String images) {
		Results insert_version=deviceService.insert_version(version_name, remarks, images);
		return insert_version;
	}
	
	@DeleteMapping(value="/delete_version/{version_id}")
	@ApiOperation(value="删除型号")
	public Results delete_version(@PathVariable int version_id) {
		Results delete_version=deviceService.delete_version(version_id);
		return delete_version;
	}
	
	@GetMapping(value="/select_all_version")
	@ApiOperation(value="查看所有的型号")
	public AllResult select_all_version() {
		AllResult select_all_version=deviceService.select_all_version();
		return select_all_version;
	}
	
	@PostMapping(value="/insert_d_add")
	@ApiOperation(value="后台添加设备")
	public Results insert_d_add(@RequestParam int version_id,@RequestParam Long device_id) {
		Results insert_d_add=deviceService.insert_d_add(version_id, device_id);
		return insert_d_add;
	}
	
	@GetMapping(value="/select_alld_add")
	@ApiOperation(value="查看所有的后台录入的设备")
	public AllResult select_alld_add(@RequestParam int start ) {
		AllResult select_alld_add=deviceService.select_alld_add(start);
		return select_alld_add;
	}
	
	@GetMapping(value="/select_vs_add")
	@ApiOperation(value="通过型号查看录入的设备")
	public AllResult select_vs_add(@RequestParam int start,@RequestParam int version_id ) {
		AllResult select_vs_add=deviceService.select_vs_add(start,version_id);
		return select_vs_add;
	}
	
	@GetMapping(value="/select_deviceadd")
	@ApiOperation(value="通过设备号查看设备")
	public Result<DeviceAdd> select_deviceadd(@RequestParam Long device_id){
		Result<DeviceAdd> select_deviceadd=deviceService.select_deviceadd(device_id);
		return select_deviceadd;
	}
	
	@PostMapping(value="/insert_picture")
	@ApiOperation(value="添加型型号对应的颜色图片(已修改)")
	public Results insert_picture(@RequestParam int version_id,@RequestParam String color,@RequestParam String picture) {
		Results insert_picture=deviceService.insert_picture(version_id, color, picture);
		return insert_picture;
	}
	
	@DeleteMapping(value="/detele_picture/{picture_id}")
	@ApiOperation(value="删除图片")
	public Results detele_picture(@PathVariable int picture_id) {
		return deviceService.detele_picture(picture_id);
	}
	
	@GetMapping(value="/select_all_picture")
	@ApiOperation(value="通过型号查看图片")
	public AllResult select_all_picture(@RequestParam int version_id ) {
		return deviceService.select_all_picture(version_id);
	}
	
	@GetMapping(value="/select_securty")
	@ApiOperation(value="用户查看定位信息(已转移)")
	public Msg select_securty(@ApiParam(value="设备id") @RequestParam Long device_id) {
		return deviceService.select_securty(device_id);
	}

	@GetMapping(value="/select_adress")
	@ApiOperation(value="根据设备id查看设备轨迹")
	public Msg select_adress(@RequestParam int start,@RequestParam Long device_id) {
		return deviceService.select_adress(start,device_id);
	}
}
