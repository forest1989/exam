package com.sgcc.exam.examInfo.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.examInfo.po.ExamOptions;
import java.io.Serializable;


public interface IExamOptionsBizc extends IBizC<ExamOptions,Serializable>{

	public ExamOptions add(ExamOptions be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public ExamOptions get(Serializable id);
	
	public void update(ExamOptions examoptions,Serializable pk);

	public Object getOpId(Serializable id);

	public void deleteExid(Serializable id);
	
	
}
