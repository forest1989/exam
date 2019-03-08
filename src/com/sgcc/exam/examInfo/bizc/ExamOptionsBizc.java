package com.sgcc.exam.examInfo.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.uap.persistence.IHibernateDao;
import com.sgcc.exam.examInfo.po.ExamOptions;
import java.io.Serializable;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;


public class ExamOptionsBizc extends BizCDefaultImpl<ExamOptions, Serializable> implements IExamOptionsBizc {
	@Autowired
	private IHibernateDao hibernateDao;
	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(ExamOptions examoptions) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(ExamOptions examoptions) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(ExamOptions examoptions) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(ExamOptions examoptions) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(ExamOptions examoptions ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(ExamOptions examoptions, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	@Override
	public ExamOptions get(Serializable id) {

		ExamOptions examoptions = super.get(id);
		/*
		if (examoptions != null) {
			Hibernate.initialize(examoptions.getExaminfo());

		}
		*/
		return examoptions;
	}

	@Override
	public QueryResultObject query(RequestCondition queryCondition) {

		QueryResultObject qo = super.query(queryCondition);
		/*
		List<ExamOptions> examoptionss = qo.getItems();
		if (examoptionss != null) {
			for (ExamOptions examoptions : examoptionss) {
				Hibernate.initialize(examoptions.getExaminfo());

			}
		}
		*/
		return qo;
	}

	@Override
	public Object getOpId(Serializable id) {
		// TODO Auto-generated method stub
		int n=this.hibernateDao.queryForIntWithSql("select count(*) from  exam_options where EXAM_ID=?", new Object[]{id});
		if(n>0){
			return this.hibernateDao.queryForObjectWithSql("select * from  exam_options where EXAM_ID=?", new Object[]{id}, ParameterizedBeanPropertyRowMapper.newInstance(ExamOptions.class));
		}else{
			return null;
		}
	}

	@Override
	public int deleteExid(Serializable id) {
		return this.hibernateDao.update("delete  from  ExamOptions where examId=?", new Object[]{id});
	}

	@Override
	public ExamOptions getInfo(Serializable pkValue) {
		int n=this.hibernateDao.queryForIntWithSql("select count(*) from  exam_options where EXAM_ID=?", new Object[]{pkValue});
		if(n>0){
			return (ExamOptions) this.hibernateDao.queryForObjectWithSql("select * from  exam_options where EXAM_ID=?", new Object[]{pkValue}, ParameterizedBeanPropertyRowMapper.newInstance(ExamOptions.class));
		}else{
			return null;
		}
	}
	
}
