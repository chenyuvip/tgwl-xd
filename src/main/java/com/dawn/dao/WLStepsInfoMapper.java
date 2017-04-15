package com.dawn.dao;

import java.util.List;

import com.dawn.pojo.WLStepsInfo;

public interface WLStepsInfoMapper
{
	int deleteByPrimaryKey(Integer stepid);

	int insert(WLStepsInfo record);

	int insertSelective(WLStepsInfo record);

	WLStepsInfo selectByPrimaryKey(Integer stepid);

	int updateByPrimaryKeySelective(WLStepsInfo record);

	int updateByPrimaryKey(WLStepsInfo record);

	List<WLStepsInfo> queryWLSteps();
}