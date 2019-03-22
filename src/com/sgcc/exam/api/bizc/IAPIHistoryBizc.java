package com.sgcc.exam.api.bizc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sgcc.exam.api.po.APIAnswerHistory;
import com.sgcc.exam.api.po.APIAnswerHistory;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;

public interface IAPIHistoryBizc extends IBizC<APIAnswerHistory,Serializable>{

	public int addHistory(List<APIAnswerHistory> list);
	
	public APIAnswerHistory add(APIAnswerHistory be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public APIAnswerHistory get(Serializable id);
	
	public void update(APIAnswerHistory area,Serializable pk);

	public  List<Map<String,Object>> getTestHistoryTitle(int userId, int pageNum, int pageSize);
	//查询练习题题历史
	public List<Map<String, Object>> getTestHistory(int userId, String date);
	//查询考试题历史
	public List<Map<String, Object>> getPaperHistory(int valueOf, int paperId);
	//在题库中查询对应的信息
	public List<Map<String, Object>> getExamInfoList(String typeId, String grade, String subject, String pageNum,
			String pageSize);
	 
	 
	
	
	
}
