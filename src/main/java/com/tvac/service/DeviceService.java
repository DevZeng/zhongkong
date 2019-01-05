package com.tvac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tvac.common.AllResult;
import com.tvac.common.Msg;
import com.tvac.common.Result;
import com.tvac.common.ResultUtil;
import com.tvac.common.Results;
import com.tvac.entriy.Color;
import com.tvac.entriy.Device;
import com.tvac.entriy.DeviceAdd;
import com.tvac.entriy.Picture;
import com.tvac.entriy.Security;
import com.tvac.entriy.Version;
import com.tvac.mapper.DeviceMapper;
import com.tvac.mapper.UserMapper;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private UserMapper userMapper;
	
	/*
	 * 绑定设备 加些缓存
	 */
	public Msg select_dev(Long device_id) {
		if(deviceMapper.select_device(device_id)>0) {
			Device select_dev=deviceMapper.select_dev(device_id);
			if(select_dev.getDevice_status()==0) {
				deviceMapper.delete_dev_status(device_id);//删除定位信息
				if(deviceMapper.update_status1(device_id)>0) {
					return ResultUtil.success(1, "SUCCESS","0");
				}
			}else {
				return ResultUtil.error(0, "设备已绑定!");
			}
		}else {
			return ResultUtil.error(0, "请联系工作人员激活设备!");
		}
		return null;
	}
	
	/*
	 * 解绑
	 */ 
	public Msg update_status0(Long device_id) {
		int update_status0=deviceMapper.update_status0(device_id);
		if(update_status0>0) {
			return ResultUtil.success(1, "解绑成功","0");
		}else {
			return ResultUtil.error(0, "解绑失败!");
		}
	}
	
	/*
	 * 添加设备型号
	 */
	public Results insert_version(String version_name,String remarks,String images) {
		Results result=new Results();
		
		int insert_version=deviceMapper.insert_version(version_name, remarks, images);
		if(insert_version==1) {
			result.setSucesss("success");
		}else {
			result.setError("添加错误!");
			return result;
		}
		return result;
	}
	
	/*
	 * 删除型号
	 */
	public Results delete_version(int version_id) {
		Results result=new Results();
		
		int delete_version=deviceMapper.delete_version(version_id);
		if(delete_version==1) {
			result.setSucesss("success");
		}else {
			result.setError("删错错误!");
			return result;
		}
		return result;
	}
	
	/*
	 * 查看所有的型号
	 */
	public AllResult select_all_version() {
		AllResult result=new AllResult();
		List<Version> select_all_version=deviceMapper.select_all_version();
		result.setData(select_all_version);
		return result;
	}
	
	/*
	 * 添加颜色
	 */
	public Results insert_color(String colour) {
		Results result=new Results();
		
		int insert_color=deviceMapper.insert_color(colour);
		if(insert_color==1) {
			result.setSucesss("success");
		}else {
			result.setError("添加错误!");
			return result;
		}
		return result;
	}
	
	/*
	 * 删除颜色
	 */
	public Results delete_color(int colour_id) {
		Results result=new Results();
		
		int delete_color=deviceMapper.delete_color(colour_id);
		if(delete_color==1) {
			result.setSucesss("success");
		}else {
			result.setError("删除错误!");
			return result;
		}
		return result;
	}
	
	/*
	 * 查看所有的颜色
	 */
	public AllResult select_all_color() {
		AllResult result=new AllResult();
		List<Color> select_all_color=deviceMapper.select_all_color();
		result.setData(select_all_color);
		return result;
	}
	
	/*
	 * 添加设备
	 */
	public Results insert_d_add(int version_id,Long device_id) {
		Results result=new Results();
		int select_device=deviceMapper.select_device(device_id);
		if(select_device!=0) {
			Version select_version=deviceMapper.select_version(version_id);
			if(select_version!=null) {
				DeviceAdd select_deviceadd=deviceMapper.select_deviceadd(device_id);
				if(select_deviceadd==null) {
					int insert_d_add=deviceMapper.insert_d_add(version_id, select_version.getVersion_name(), device_id);
					if(insert_d_add==1) {
						result.setSucesss("success");
					}else {
						result.setError("添加失败");
						return result;
					}
				}else {
					result.setError("您已录入了该设备号了!");
					return result;
				}
			}else {
				result.setError("型号为空");
				return result;
			}
		}else {
			result.setError("请先激活设备!");
			return result;
		}
		return result;
	}
	
	/*
	 * 查看所有的后台录入的设备
	 */
	public AllResult select_alld_add(int start ) {
		AllResult result=new AllResult();
		PageHelper.startPage(start, 10);
		List<DeviceAdd> select_alld_add=deviceMapper.select_alld_add();
		Page<DeviceAdd> list_alld=(Page<DeviceAdd>)select_alld_add;
		result.setData(list_alld);
		result.setTotal(list_alld.getTotal());
		return result;
	}
	
	/*
	 * 通过型号查看录入的设备
	 */
	public AllResult select_vs_add(int start,int version_id) {
		AllResult result=new AllResult();
		PageHelper.startPage(start, 10);
		List<DeviceAdd> select_vs_add=deviceMapper.select_vs_add(version_id);
		Page<DeviceAdd> list_vslld=(Page<DeviceAdd>)select_vs_add;
		result.setData(list_vslld);
		result.setTotal(list_vslld.getTotal());
		return result;
	}
	
	/*
	 * 查看设备号
	 */
	public Result<DeviceAdd> select_deviceadd(Long device_id){
		Result<DeviceAdd> result=new Result<DeviceAdd>();
		DeviceAdd select_deviceadd=deviceMapper.select_deviceadd(device_id);
		result.setResult(select_deviceadd);
		return result;
	}
	
	/*
	 * 添加型型号对应的颜色图片
	 */
	public Results insert_picture(int version_id,String color,String picture) {
		Results result=new Results();
		Version select_version=deviceMapper.select_version(version_id);
		if(select_version!=null) {
			int insert_picture=deviceMapper.insert_picture(version_id, select_version.getVersion_name(), 0, color, picture);
			if(insert_picture==1) {
				result.setSucesss("success");
			}else {
				result.setError("添加失败");
				return result;
			}
		}else {
			result.setError("你输入有误!");
			return result;
		}
		return result;
	}
	
	/*
	 * 删除图片
	 */	
	public Results detele_picture(int picture_id) {
			Results result=new Results();
			
			int detele_picture=deviceMapper.detele_picture(picture_id);
			if(detele_picture==1) {
				result.setSucesss("success");
			}else {
				result.setError("删除错误!");
				return result;
			}
			return result;
		}
	
	/*
	 * 通过型号查看图片
	 */
	public AllResult select_all_picture(int version_id ) {
		AllResult result=new AllResult();
		List<Picture> select_all_picture=deviceMapper.select_all_picture(version_id);
		result.setData(select_all_picture);
		return result;
	}
	
	/*
	 * 用户查看设备
	 */
	public Msg select_securty(Long device_id) {
		return ResultUtil.success(deviceMapper.select_securty(device_id), "SUCCESS",null);
	}
	
	/*
	 * 根据设备id查看设备信息
	 */
	public Msg select_adress(int start,Long device_id) {
		PageHelper.startPage(start, 50);
		List<Security> select_adress=deviceMapper.select_adress(device_id);
		Page<Security> list_vslld=(Page<Security>)select_adress;
		return ResultUtil.success(list_vslld, "SUCCESS", String.valueOf(list_vslld.getTotal()));
	}
	
	/*
	 * 通过设备号查看绑定的信息
	 */
//	public Result<Device_Stu> select_d_dev(Long device_id){
//		Result<Device_Stu> result=new Result<Device_Stu>();
//		Device_Stu select_d_dev=device_StuMapper.select_d_dev(device_id);
//		result.setResult(select_d_dev);
//		return result;
//	}
	
	/*
	 * 解除设备号
	 */
//	public Results delete_dev(Long device_id) {
//		Results result=new Results();
//		
//		int delete_dev=device_StuMapper.delete_dev(device_id);
//		if(delete_dev==1) {
//			result.setSucesss("success");
//		}else {
//			result.setError("删错错误!");
//			return result;
//		}
//		return result;
//	}
	
	/*
	 * 后台查看绑定设备信息
	 */
//	public AllResult select_all(int start) {
//		AllResult result=new AllResult();
//		PageHelper.startPage(start, 10);
//		List<Device_Stu> select_all=device_StuMapper.select_all();
//		Page<Device_Stu> listapply=(Page<Device_Stu>)select_all;
//		result.setData(listapply);
//		result.setTotal(listapply.getTotal());
//		return result;
//	}
}
