package com.sgcc.exam.etype.bizc;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.exam.examInfo.po.ExamOptions;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.uap.persistence.IHibernateDao;

import java.io.Serializable;


public class ExamTypeBizc extends BizCDefaultImpl<ExamType, Serializable> implements IExamTypeBizc {
	@Autowired
	private IHibernateDao hibernateDao;
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

	@Override
	public ExamType getExamtype(Integer valueOf) {
		int n=this.hibernateDao.queryForIntWithSql("select count(*) from  exam_type where EXAM_TYPE_ID=?", new Object[]{valueOf});
		if(n>0){
			return (ExamType) this.hibernateDao.queryForObjectWithSql("select * from  exam_type where EXAM_TYPE_ID=?", new Object[]{valueOf}, ParameterizedBeanPropertyRowMapper.newInstance(ExamType.class));
		}else{
			return null;
		}
	}
	
}
