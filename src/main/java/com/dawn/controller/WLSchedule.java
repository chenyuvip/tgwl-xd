package com.dawn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawn.dao.OrderInfoMapper;
import com.dawn.dao.WLDetailsInfoMapper;
import com.dawn.dao.WLStepsInfoMapper;
import com.dawn.pojo.OrderInfo;
import com.dawn.pojo.WLDetailsInfo;
import com.dawn.pojo.WLStepsInfo;
import com.dawn.util.DateUtil;

@Controller
public class WLSchedule
{
	@Autowired
	WLStepsInfoMapper wlStepInfoMapper;

	@Autowired
	OrderInfoMapper orderInfoMapper;

	@Autowired
	WLDetailsInfoMapper wlDetailsMapper;

	private static Logger log = LoggerFactory.getLogger(WLSchedule.class);

	@RequestMapping("/wlSchedule/generate")
	public void wlGenerateSchedule()
	{
		orderInfoMapper.clearWrongOrders();
		
		List<WLStepsInfo> wlDetailsList = wlStepInfoMapper.queryWLSteps();
		List<OrderInfo> orderList = orderInfoMapper.queryUnGeneratedOrders();

		for (OrderInfo orderInfo : orderList)
		{
			for (int index = 0; index < wlDetailsList.size(); index++)
			{
				WLStepsInfo wlStepsInfo = wlDetailsList.get(index);
				try
				{
					WLDetailsInfo wlDetailsInfo = new WLDetailsInfo();
					wlDetailsInfo.setOrderno(orderInfo.getOrderno());
					wlDetailsInfo.setStepid(wlStepsInfo.getStepid());

					if (index == wlDetailsList.size() - 1)
					{
						wlDetailsInfo.setStepinfo(wlStepsInfo.getStepinfo() + orderInfo.getExpressno());
					} else
					{
						wlDetailsInfo.setStepinfo(wlStepsInfo.getStepinfo());
					}

					wlDetailsInfo.setCurtime(
							getCurrentTime(wlStepsInfo.getHours(), wlStepsInfo.getMinutes(), orderInfo.getOrdertime()));
					try
					{
						wlDetailsMapper.insert(wlDetailsInfo);
					}catch(Exception e)
					{
						log.debug(e.getMessage());
					}
					
				} catch (ParseException e)
				{
					log.debug(e.getMessage());
				}
			}
			/*
			 * for(WLStepsInfo wlStepsInfo : wlDetailsList) { try {
			 * WLDetailsInfo wlDetailsInfo = new WLDetailsInfo();
			 * wlDetailsInfo.setOrderno(orderInfo.getOrderno());
			 * wlDetailsInfo.setStepid(wlStepsInfo.getStepid());
			 * wlDetailsInfo.setStepinfo(wlStepsInfo.getStepinfo());
			 * wlDetailsInfo.setCurtime(getCurrentTime(wlStepsInfo.getHours(),
			 * wlStepsInfo.getMinutes(), orderInfo.getOrdertime()));
			 * wlDetailsMapper.insert(wlDetailsInfo); } catch (ParseException e)
			 * { log.debug(e.getMessage()); } }
			 */

			// 将状态变为已完成
			int ok = orderInfoMapper.updateGenerateStatus(orderInfo.getOrderno());
		}

	}

	private static String getCurrentTime(Integer hour, Integer minute, String orderTime) throws ParseException
	{
		String pattern = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = DateUtil.parse(orderTime, pattern);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, hour * 60 + minute);

		return sdf.format(calendar.getTimeInMillis());
	}
}
