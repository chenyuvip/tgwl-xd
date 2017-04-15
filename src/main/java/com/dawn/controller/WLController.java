package com.dawn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawn.dao.WLDetailsInfoMapper;

@Controller
public class WLController
{
	@Autowired
	WLDetailsInfoMapper wlDetailsMapper;
	
	public void setWlDetailsMapper(WLDetailsInfoMapper wlDetailsMapper)
	{
		this.wlDetailsMapper = wlDetailsMapper;
	}

	//游客首页展示界面
	@RequestMapping("/index")
	public ModelAndView test(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("layout/main");
		String orderno = request.getParameter("orderno");
		
		if(orderno!=null && !"".equals(orderno))
		{
			List wlDeatails = wlDetailsMapper.queryWLDetails(orderno);
			
			if( wlDeatails!=null && wlDeatails.size()!=0)
			{
				mv.addObject("wlDeatails", wlDeatails);
			}else{
				mv.addObject("message", "无此订单号或者暂无物流信息");
			}
			
			mv.addObject("orderno", orderno);
		}
		
		
		return mv;
	}
	
	
	
}
