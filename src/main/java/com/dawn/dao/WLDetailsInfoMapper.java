package com.dawn.dao;

import java.util.List;

import com.dawn.pojo.WLDetailsInfo;
import com.dawn.pojo.WLDetailsInfoKey;

public interface WLDetailsInfoMapper
{
	int deleteByPrimaryKey(WLDetailsInfoKey key);

	int insert(WLDetailsInfo record);

	int insertSelective(WLDetailsInfo record);

	WLDetailsInfo selectByPrimaryKey(WLDetailsInfoKey key);

	int updateByPrimaryKeySelective(WLDetailsInfo record);

	int updateByPrimaryKey(WLDetailsInfo record);
	
	List queryWLDetails(String orderno);
	
	
}