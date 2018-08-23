package com.tvac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.mapper.ApkMapper;


@Service
public class ApkService {

	@Autowired
	private ApkMapper apkMapper;
	
	/*
	 * 添加一级分类
	 */
	public Msg insert_main(String main_name) {
		return ResultUtil.success(apkMapper.insert_main(main_name), "SUCCESS", null);
	}
	
	/*
	 * 查看一级分类 
	 */
	public Msg select_main() {
		return ResultUtil.success(apkMapper.select_main(), "SUCCESS", null);
	}
	
	/*
	 * 添加二级分类
	 */
	public Msg insert_two(int id,String two_name) {
		return ResultUtil.success(apkMapper.insert_two(id, two_name), "SUCCESS", null);
	}
	
	/*
	 * 添加查看二级分类
	 */
	public Msg select_two(int id) {
		return ResultUtil.success(apkMapper.select_two(id), "SUCCESS", null);
	}
	
	/*
	 * 插入apk
	 */
	public Msg insert_apk(int two_id,String apk_address,String domain_name,String apk_edition) {
		return ResultUtil.success(apkMapper.insert_apk(two_id, apk_address, domain_name, apk_edition), "SUCCESS", null);
	}
	
	/*
	 * 修改apk
	 */
	public Msg update_apk(String apk_address,String domain_name,String apk_edition,int id) {
		return ResultUtil.success(apkMapper.update_apk(apk_address, domain_name, apk_edition,id), "SUCCESS", null);
	}
	
	/*
	 * 查看apk
	 */
	public Msg select_apk(int two_id) {
		return ResultUtil.success(apkMapper.select_apk(two_id), "SUCCESS", null);
	}
	
	/*
	 * 查看所有的apk
	 */
	public Msg select_all_apk() {
		return ResultUtil.success(apkMapper.select_all_apk(), "SUCCESS", null);
	}
}
