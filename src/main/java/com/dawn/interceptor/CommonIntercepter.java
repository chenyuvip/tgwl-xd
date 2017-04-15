package com.dawn.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonIntercepter extends HandlerInterceptorAdapter
{
	/** 
	* 免登入 免检查地址 
	*/ 
	private List<String> uncheckUrls; 

	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), ""); 
		if(uncheckUrls.contains(requestUrl)){ 
			return true; 
		}
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		if(name == null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
