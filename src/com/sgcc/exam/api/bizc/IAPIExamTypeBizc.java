package com.sgcc.exam.api.bizc;

import java.util.*;

import com.sgcc.exam.api.po.APIExamType;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;


public interface IAPIExamTypeBizc extends IBizC<APIExamType,Serializable>{

	public APIExamType add(APIExamType be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public APIExamType get(Serializable id);
	
	public void update(APIExamType examtype,Serializable pk);

	public APIExamType getExamtype(Integer valueOf);
	
	public List<APIExamType> getParents();

	public List<APIExamType> getSons(String id);

	public List<Map<String,Object>> getExamTypeInfos(String id, String size);

	public List<Map<String, Object>> getExamInfos(String size);
	
	public List<Map<String, Object>> getExamResult(String ids);
	//查询练习题或者考试题历史记录对应的完整题目信息
	public List<Map<String, Object>> getChooseExamInfos(String ids);
	
}
