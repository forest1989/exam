package com.sgcc.exam.etype.bizc;

import java.util.*;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;


public interface IExamTypeBizc extends IBizC<ExamType,Serializable>{

	public ExamType add(ExamType be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public ExamType get(Serializable id);
	
	public void update(ExamType examtype,Serializable pk);
	
	
}
