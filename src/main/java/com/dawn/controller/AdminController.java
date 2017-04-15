package com.dawn.controller;

import com.dawn.constant.Constants;
import com.dawn.dao.OrderInfoMapper;
import com.dawn.pojo.OrderInfo;
import com.dawn.util.ExcelUtil;
import com.dawn.util.FileUtil;
import com.dawn.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	//CheckAuthService authService = new CheckAuthService();
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("admin/index");
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		mv.addObject("defaultDate", formater.format(new Date()));
		
		return mv;
	}
	
	@RequestMapping("/doSimpleOrder")
	@ResponseBody
	public Map doSimpleOrder(HttpServletRequest request)
	{
		//String orderno = request.getParameter("orderno");
		//String datetimepicker = request.getParameter("datetimepicker");
		//String pattern = "yyyy-MM-dd HH:mm";
		//ModelAndView mv = new ModelAndView("admin/index");
		
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderno(request.getParameter("orderno"));
		orderInfo.setOrdertime(request.getParameter("datetimepicker"));
		orderInfo.setItime(new Date());
		orderInfo.setCurrentstep(0);
		Map<String,Integer> result = new HashMap<String,Integer>(1);
		try
		{
			int status = orderInfoMapper.insert(orderInfo);
			result.put("errorCode", status);
		} catch (Exception e)
		{
			log.debug(e.getMessage());
			result.put("errorCode", Constants.ErrorCode.FAIL_CODE);
		}
		
		return result;
	}
	
	@RequestMapping("/doPatchOrders")
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public ModelAndView doPatchOrders(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("admin/index");
		MultipartFile excelFile = FileUtil.getUploadFile(request);
		String fileExt = FileUtil.getFileExt(excelFile.getOriginalFilename());
		if(!FileUtil.checkExcelExt(fileExt))
		{
			return mv;
		}
		
		ArrayList<ArrayList<String>> datas = ExcelUtil.readExcel(excelFile);
		
		int insok = 0;
		int infail = 0;
		/*try
		{*/
			for (ArrayList<String> cell : datas) 
			{
				if(StringUtils.matches(cell.get(0),"^[0-9]*$"))
				{
					OrderInfo orderInfo = new OrderInfo();
					orderInfo.setCurrentstep(0);
					orderInfo.setOrderno(cell.get(0).trim());
					orderInfo.setOrdertime(cell.get(1));
					orderInfo.setExpressno(cell.get(2));
					orderInfo.setItime(new Date());
					try
					{
						orderInfoMapper.insert(orderInfo);
						insok = insok+1;
					} catch (Exception e)
					{
						infail = infail+1;
						log.debug(e.getMessage());
						e.printStackTrace();
					}
					
				}
			}
		/*} catch (Exception e)
		{
			mv.addObject("errorCode", Constants.ErrorCode.FAIL_CODE);
			log.debug(e.getMessage());
		}*/
		
		mv.addObject("errorCode", Constants.ErrorCode.PASS_CODE);
		mv.addObject("message", "共计："+(insok+infail)+"条，成功："+insok+"条，失败："+infail+"条");
		
		return mv;
	}
	
	/*private boolean checkExcel(StringBuffer message, ArrayList<ArrayList<String>> datas)
	{
		for (ArrayList<String> cell : datas)
		{
			if (StringUtils.matches(cell.get(0), "^[0-9]*$"))
			{
				
			}
		}

		return false;
	}*/
	
	/*@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, ModelAndView mv)
	{
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roleid = "000";
		
		//User user = new User(username, password, roleid);
		
		boolean isAdmin = true;
				//authService.checkAdminAuth(user);
		
		if(isAdmin)
		{
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("roleid", roleid);
			
			mv = new ModelAndView("admin/index");
			mv.addObject("code", Constants.ErrorCode.PASS_CODE);
		}else
		{
			mv = new ModelAndView("admin/login");
			mv.addObject("code", Constants.ErrorCode.WRONG_LOGIN);
		}
		
		return mv;
	}*/
	
	
}
