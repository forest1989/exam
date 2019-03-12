package com.sgcc.exam.api.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.exam.api.po.Area;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;


public class AreaBizc extends BizCDefaultImpl<Area, Serializable> implements IAreaBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(Area area) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(Area area) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(Area area) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(Area area) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(Area area ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(Area area, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
