package com.sgcc.exam.testJene.bizc;
import com.sgcc.exam.testJene.po.AutomaticRule;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;
import org.hibernate.Hibernate;


public class AutomaticRuleBizc extends BizCDefaultImpl<AutomaticRule, Serializable> implements IAutomaticRuleBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(AutomaticRule automaticrule) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(AutomaticRule automaticrule) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(AutomaticRule automaticrule) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(AutomaticRule automaticrule) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(AutomaticRule automaticrule ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(AutomaticRule automaticrule, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	@Override
	public AutomaticRule get(Serializable id) {

		AutomaticRule automaticrule = super.get(id);

		if (automaticrule != null) {
			Hibernate.initialize(automaticrule.getTestpaper());

		}

		return automaticrule;
	}

	@Override
	public QueryResultObject query(RequestCondition queryCondition) {

		QueryResultObject qo = super.query(queryCondition);

		List<AutomaticRule> automaticrules = qo.getItems();
		if (automaticrules != null) {
			for (AutomaticRule automaticrule : automaticrules) {
				Hibernate.initialize(automaticrule.getTestpaper());

			}
		}

		return qo;
	}
	
}
