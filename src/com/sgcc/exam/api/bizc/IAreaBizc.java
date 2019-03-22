package com.sgcc.exam.api.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.api.po.Area;
import com.sgcc.exam.rguser.po.MUser;
import com.sgcc.exam.testpaper.po.APITestPaper;

import java.io.Serializable;


public interface IAreaBizc extends IBizC<Area,Serializable>{

	public Area add(Area be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public Area get(Serializable id);
	
	public void update(Area area,Serializable pk);
	
	/**
	 * 根据openId查询用户是否存在
	 * */
	public Integer getUserId(String openId);
	
	/**
	 * 获取试卷列表
	 * */
	public List<APITestPaper> getPaper();
	
	/**
	 * 
	 * 根据试卷ID获取试题类型
	 * */
	public List<Map<String , Object>> getexamTypeId(String testPaperId , String testPaperType);
	
	/**
	 * 获取指定试卷
	 * */
	public List<Map<String,Object>>getListPaper(Map<String , Object> map, String testPaperType);
}
