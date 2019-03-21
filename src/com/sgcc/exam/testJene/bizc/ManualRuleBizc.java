package com.sgcc.exam.testJene.bizc;
import java.util.*;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import java.io.Serializable;
import org.hibernate.Hibernate;
import com.sgcc.exam.testJene.po.ManualRule;


public class ManualRuleBizc extends BizCDefaultImpl<ManualRule, Serializable> implements IManualRuleBizc {

	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(ManualRule manualrule) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(ManualRule manualrule) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(ManualRule manualrule) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(ManualRule manualrule) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(ManualRule manualrule ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(ManualRule manualrule, Serializable pk) {
		// 自定义逻辑
		return true;
	}
	@Override
	public ManualRule get(Serializable id) {

		ManualRule manualrule = super.get(id);

		if (manualrule != null) {
			Hibernate.initialize(manualrule.getTestpaper());

		}

		return manualrule;
	}

	@Override
	public QueryResultObject query(RequestCondition queryCondition) {

		QueryResultObject qo = super.query(queryCondition);

		List<ManualRule> manualrules = qo.getItems();
		if (manualrules != null) {
			for (ManualRule manualrule : manualrules) {
				Hibernate.initialize(manualrule.getTestpaper());

			}
		}

		return qo;
	}
	
}
