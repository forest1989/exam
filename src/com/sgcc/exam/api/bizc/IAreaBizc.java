package com.sgcc.exam.api.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.api.po.Area;
import java.io.Serializable;


public interface IAreaBizc extends IBizC<Area,Serializable>{

	public Area add(Area be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public Area get(Serializable id);
	
	public void update(Area area,Serializable pk);
	
	
}
