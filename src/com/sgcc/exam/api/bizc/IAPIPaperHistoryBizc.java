package com.sgcc.exam.api.bizc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sgcc.exam.api.po.APIPaperHistory;
import com.sgcc.exam.api.po.APIPaperHistory;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;

public interface IAPIPaperHistoryBizc extends IBizC<APIPaperHistory,Serializable>{
	public APIPaperHistory add(APIPaperHistory be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public APIPaperHistory get(Serializable id);
	
	public void update(APIPaperHistory area,Serializable pk);

	public List<Map<String, Object>> getPaperHistoryTitle(int valueOf, int i, int valueOf2);

	public List<Map<String, Object>> getPaperList(int start, int size);

	public List<Map<String, Object>> getPaperListByName(String paperName, int start, int size);

	public String getPaperType(Integer paperId);

	public List<Map<String, Object>> getAutoExamInfos(int valueOf);

	public List<Map<String, Object>> getHandExamInfos(Integer valueOf);
}
