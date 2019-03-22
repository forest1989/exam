package com.sgcc.exam.testpaper.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;
import com.sgcc.exam.testpaper.po.APITestPaper;


public interface IAPITestPaperBizc extends IBizC<APITestPaper,Serializable>{

	public APITestPaper add(APITestPaper be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public APITestPaper get(Serializable id);
	
	public void update(APITestPaper testpaper,Serializable pk);
	
	
}
