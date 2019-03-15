package com.sgcc.exam.readtext.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.readtext.po.ReadingText;
import java.io.Serializable;


public interface IReadingTextBizc extends IBizC<ReadingText,Serializable>{

	public ReadingText add(ReadingText be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public ReadingText get(Serializable id);
	
	public void update(ReadingText readingtext,Serializable pk);
	
	
}
