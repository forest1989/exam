package com.sgcc.exam.rguser.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.rguser.po.MUser;
import java.io.Serializable;


public interface IMUserBizc extends IBizC<MUser,Serializable>{

	public MUser add(MUser be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public MUser get(Serializable id);
	
	public void update(MUser muser,Serializable pk);
	
	
}
