package com.dawn.util;

import org.apache.regexp.RE;

public class StringUtils
{
	public static boolean isBlank(String str)
	{
		if (str == null || "".equals(str))
		{
			return true;
		}
		return false;
	}

	public static boolean matches(String value, String regexp)
	{
		String paren = null;
		RE re = null;

		if (regexp == null ||  value == null)
		{
			return false;
		}
		re = new RE(regexp);
		if (!re.match(value))
		{
			return false;
		}
		paren = re.getParen(0);
		if (!paren.equals(value))
		{
			return false;
		}

		return true;
	}
}
