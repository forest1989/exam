package com.sgcc.exam.wxImages.bizc;

import java.util.*;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.base.IBizC;
import com.sgcc.exam.wxImages.po.WxImageConf;
import java.io.Serializable;


public interface IWxImageConfBizc extends IBizC<WxImageConf,Serializable>{

	public WxImageConf add(WxImageConf be);
	
	public void delete(Serializable id);
	
	public QueryResultObject query(RequestCondition queryCondition);
	
	public WxImageConf get(Serializable id);
	
	public void update(WxImageConf wximageconf,Serializable pk);
	
	
}
