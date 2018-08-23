package com.tvac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tvac.entriy.Order;

@Mapper
public interface OrderMapper {

	int insert_order(Order order);//添加订单
	
	Order select_order(@Param("order_id") Long order_id);//查看单个订单情况
	
	List<Order> select_all_order();//查看所有的订单
	
	List<Order> select_user_order(@Param("user_openid") String user_openid);//用户查看订单情况
	
	int update_order1(@Param("order_id") Long order_id);//支付成功
	
	int update_order2(@Param("order_id") Long order_id);//退款中
	
	int update_order3(@Param("order_id") Long order_id);//退款成功
	
	int detele_order(@Param("order_id") Long order_id);//删除订单
	
	Double select_num(@Param("school_id") Long school_id);//查看订单的总数
	
	List<Order> select_ord_b(@Param("school_id") Long school_id);//查看订单数
	
	Double select_ord_sum();//查看总额
}
