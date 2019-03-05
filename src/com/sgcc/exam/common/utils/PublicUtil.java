package com.sgcc.exam.common.utils;

import java.net.URL;

/**
 * 功能:公共处理
 * 
 
 */
public class PublicUtil
{
	/**
	 * 判断字符串是否为空,如果为空，则用第二个参数代替
	 * @param nvl 要判断的字符串
	 * @param defaultStr 当第一个参数为空时，替换的值
	 * @return true/false
	 */
	public static String nvl(Object val, String defaultStr) {
		boolean nvl = PublicUtil.nvl(val);
		if(nvl) {
			return defaultStr;
		}
		return val.toString().trim();
	}   
	  /**
		 * 判断字符串是否为空
		 * @param nvl 要判断的字符串
		 * @return true/false
		 */
		public static boolean nvl(Object val) {
			String valStr = val+"";
			if(valStr.trim().length() > 0 && !"NULL".equalsIgnoreCase(valStr)) {
				return false;
			}
			return true;
		}
	/**
	    * 去掉空值
	    * 
	    * @param str 原值
	    * @return String 处理后值
	    */
	public static String nvlString(Object str)
	   {
	      String s_temp = "" + str;
	      if (s_temp == null || "NULL".equals(s_temp.toUpperCase()))
	      {
	         s_temp = "";
	      }
	      return s_temp.trim();
	   }
	/**
	 * 得到java文件跟目录
	 * @param clss
	 * @return
	 */
	public static String getRootPath(@SuppressWarnings("rawtypes") Class clss) {
		URL url = clss.getProtectionDomain().getCodeSource().getLocation();
		return url.getPath();
	}
   
}
