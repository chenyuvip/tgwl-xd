package com.dawn.pojo;

public class WLDetailsInfo extends WLDetailsInfoKey
{
	private String stepinfo;

	private String curtime;

	public String getStepinfo()
	{
		return stepinfo;
	}

	public void setStepinfo(String stepinfo)
	{
		this.stepinfo = stepinfo == null ? null : stepinfo.trim();
	}

	public String getCurtime()
	{
		return curtime;
	}

	public void setCurtime(String curtime)
	{
		this.curtime = curtime == null ? null : curtime.trim();
	}
}