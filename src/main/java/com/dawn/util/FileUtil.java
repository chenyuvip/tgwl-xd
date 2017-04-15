package com.dawn.util;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtil
{
	public static MultipartFile getUploadFile(HttpServletRequest request)
	{
		MultipartFile file = null;
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request))
		{
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext())
			{
				// 记录上传过程起始时的时间，用来计算上传时间
				// int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				file = multiRequest.getFile(iter.next().toString());
			}
		}
		return file;
	}
	
	/**
	 * 获取文件的后缀
	 * @param formFilename
	 * @return
	 */
	public static String getFileExt(String formFilename)
	{
		String picExt = formFilename.substring(formFilename.lastIndexOf(".") + 1, formFilename.length()).toLowerCase();
		return picExt;
	}

	/**
	 * 检查是否是xls文件
	 * 
	 * @param ext
	 * @return
	 */
	public static boolean checkExcelExt(String ext)
	{
		String realExt = ext.toLowerCase();
		if ("xls".equals(realExt) || "xlsx".equals(realExt))
		{
			return true;
		}
		return false;
	}
}
