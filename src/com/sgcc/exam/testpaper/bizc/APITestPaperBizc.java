package com.sgcc.exam.testpaper.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;
import com.sgcc.exam.testpaper.po.APITestPaper;


public class APITestPaperBizc extends BizCDefaultImpl<APITestPaper, Serializable> implements IAPITestPaperBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(APITestPaper testpaper) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(APITestPaper testpaper) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(APITestPaper testpaper) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(APITestPaper testpaper) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(APITestPaper testpaper ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(APITestPaper testpaper, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
