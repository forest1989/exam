package com.sgcc.exam.etype.bizc;
import java.util.*;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;


public class ExamTypeBizc extends BizCDefaultImpl<ExamType, Serializable> implements IExamTypeBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(ExamType examtype) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(ExamType examtype) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(ExamType examtype) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(ExamType examtype) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(ExamType examtype ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(ExamType examtype, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
