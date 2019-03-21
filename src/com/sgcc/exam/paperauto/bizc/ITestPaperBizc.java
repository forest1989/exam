package com.sgcc.exam.paperauto.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;
import com.sgcc.exam.paperauto.po.TestPaper;


public interface ITestPaperBizc extends IBizC<TestPaper,Serializable>{

	public TestPaper add(TestPaper be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public TestPaper get(Serializable id);
	
	public void update(TestPaper testpaper,Serializable pk);
	
	
}
