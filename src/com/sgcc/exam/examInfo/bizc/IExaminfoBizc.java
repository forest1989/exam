package com.sgcc.exam.examInfo.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.examInfo.po.Examinfo;
import java.io.Serializable;


public interface IExaminfoBizc extends IBizC<Examinfo,Serializable>{

	public Examinfo add(Examinfo be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public Examinfo get(Serializable id);
	
	public void update(Examinfo examinfo,Serializable pk);

	public void updateReadId(Serializable pkValue,String readingId);
	
	
}
