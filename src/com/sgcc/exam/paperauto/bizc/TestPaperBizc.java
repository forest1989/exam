package com.sgcc.exam.paperauto.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;
import com.sgcc.exam.paperauto.po.TestPaper;


public class TestPaperBizc extends BizCDefaultImpl<TestPaper, Serializable> implements ITestPaperBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(TestPaper testpaper) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(TestPaper testpaper) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(TestPaper testpaper) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(TestPaper testpaper) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(TestPaper testpaper ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(TestPaper testpaper, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
