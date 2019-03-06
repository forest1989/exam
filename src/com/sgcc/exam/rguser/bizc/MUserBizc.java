package com.sgcc.exam.rguser.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.exam.rguser.po.MUser;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;


public class MUserBizc extends BizCDefaultImpl<MUser, Serializable> implements IMUserBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(MUser muser) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(MUser muser) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(MUser muser) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(MUser muser) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(MUser muser ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(MUser muser, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
