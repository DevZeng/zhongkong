package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Apk;
import com.tvac.entriy.MainClass;
import com.tvac.entriy.TwoClass;

@Mapper
public interface ApkMapper {

	int insert_main(@Param("main_name") String main_name);//添加一级分类
	
	List<MainClass> select_main();//查看一级分类 
	
	int insert_two(@Param("id") int id,@Param("two_name") String two_name);//添加二级分类
	
	List<TwoClass> select_two(@Param("id") int id);//添加查看二级分类
	
	int insert_apk(@Param("two_id") int two_id,@Param("apk_address") String apk_address,@Param("domain_name") String domain_name,@Param("apk_edition") String apk_edition);//插入apk
	
	int update_apk(@Param("apk_address") String apk_address,@Param("domain_name") String domain_name,@Param("apk_edition") String apk_edition,@Param("id") int id);//修改apk
	
	List<Apk> select_apk(@Param("two_id") int two_id);//查看apk
	
	List<Apk> select_all_apk();//查看所有的apk
}
