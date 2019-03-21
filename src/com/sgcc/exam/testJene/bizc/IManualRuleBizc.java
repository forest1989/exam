package com.sgcc.exam.testJene.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;
import com.sgcc.exam.testJene.po.ManualRule;


public interface IManualRuleBizc extends IBizC<ManualRule,Serializable>{

	public ManualRule add(ManualRule be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public ManualRule get(Serializable id);
	
	public void update(ManualRule manualrule,Serializable pk);
	
	
}
