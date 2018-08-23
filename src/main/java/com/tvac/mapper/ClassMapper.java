package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Classif;

@Mapper
public interface ClassMapper {

	int insert_class(@Param("class_name") String class_name);//添加分类
	
	int delete_class(@Param("class_id") int class_id);//删除分类
	
	List<Classif> select_list();//查看所有的分类
}
