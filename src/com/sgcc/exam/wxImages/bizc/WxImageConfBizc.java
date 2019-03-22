package com.sgcc.exam.wxImages.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.exam.wxImages.po.WxImageConf;
import java.io.Serializable;


public class WxImageConfBizc extends BizCDefaultImpl<WxImageConf, Serializable> implements IWxImageConfBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(WxImageConf wximageconf) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(WxImageConf wximageconf) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(WxImageConf wximageconf) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(WxImageConf wximageconf) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(WxImageConf wximageconf ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(WxImageConf wximageconf, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
