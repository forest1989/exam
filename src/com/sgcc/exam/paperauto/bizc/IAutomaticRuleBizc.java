package com.sgcc.exam.paperauto.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import java.io.Serializable;
import com.sgcc.exam.paperauto.po.AutomaticRule;


public interface IAutomaticRuleBizc extends IBizC<AutomaticRule,Serializable>{

	public AutomaticRule add(AutomaticRule be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public AutomaticRule get(Serializable id);
	
	public void update(AutomaticRule automaticrule,Serializable pk);
	
	
}
