package com.dawn.dao;

import java.util.List;

import com.dawn.pojo.OrderInfo;

public interface OrderInfoMapper
{
	int deleteByPrimaryKey(String orderno);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	OrderInfo selectByPrimaryKey(String orderno);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);
	
	List<OrderInfo> queryUnGeneratedOrders();
	
	int updateGenerateStatus(String orderno);
	
	int clearWrongOrders();
}