package com.sgcc.exam.examInfo.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.exam.examInfo.po.Examinfo;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;


public class ExaminfoBizc extends BizCDefaultImpl<Examinfo, Serializable> implements IExaminfoBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(Examinfo examinfo) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(Examinfo examinfo) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(Examinfo examinfo) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(Examinfo examinfo) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(Examinfo examinfo ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(Examinfo examinfo, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
