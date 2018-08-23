package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Color;
import com.tvac.entriy.Device;
import com.tvac.entriy.DeviceAdd;
import com.tvac.entriy.Picture;
import com.tvac.entriy.Security;
import com.tvac.entriy.Version;

@Mapper
public interface DeviceMapper {
	
	int select_device(@Param("device_id") Long device_id);//查询是否有设备
	
	Device select_dev(@Param("device_id") Long device_id);//查看设备
	
	int update_status1(@Param("device_id") Long device_id);//更新设备绑定
	
	int update_status0(@Param("device_id") Long device_id);//解绑
	
	int insert_version(@Param("version_name") String version_name,@Param("remarks") String remarks,@Param("images") String images);//添加设备型号
	
	int delete_version(@Param("version_id") int version_id);//删除型号
	
	Version select_version(@Param("version_id") int version_id);//查看型号
	
	List<Version> select_all_version();//查看所有的型号
	
	int insert_color(@Param("colour") String colour);//添加颜色
	
	int delete_color(@Param("colour_id") int colour_id);//删除颜色

	List<Color> select_all_color();//查看所有的颜色
	
	Color select_color(@Param("colour_id") int colour_id);//查看颜色
	
	int insert_d_add(@Param("version_id") int version_id,@Param("version_name") String version_name,@Param("device_id") Long device_id);//添加设备
	
	List<DeviceAdd> select_alld_add();//查看所有的后台录入的设备
	
	List<DeviceAdd> select_vs_add(@Param("version_id") int version_id);//通过型号查看录入的设备
	
	DeviceAdd select_deviceadd(@Param("device_id") Long device_id);//查看设备号
	
	int insert_picture(@Param("version_id") int version_id,@Param("version_name") String version_name,@Param("colour_id") int colour_id,@Param("colour") String colour,@Param("picture") String picture);//添加型型号对应的颜色图片
	
	int detele_picture(@Param("picture_id") int picture_id);//删除图片
	
//	Picture select_picture(@Param("picture_id") int picture_id);//查看图片
	
	List<Picture> select_all_picture(@Param("version_id") int version_id);//通过型号查看图片
	
	Security select_securty(@Param("device_id") Long device_id);//查看定位信息
	
	List<Security> select_adress(@Param("device_id") Long device_id);//根据设备id查看设备信息
	
	int delete_dev_status(@Param("device_id") Long device_id);//删除定位信息
}


