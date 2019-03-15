package com.sgcc.exam.readtext.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.exam.readtext.po.ReadingText;
import java.io.Serializable;


public class ReadingTextBizc extends BizCDefaultImpl<ReadingText, Serializable> implements IReadingTextBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(ReadingText readingtext) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(ReadingText readingtext) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(ReadingText readingtext) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(ReadingText readingtext) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(ReadingText readingtext ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(ReadingText readingtext, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	
}
