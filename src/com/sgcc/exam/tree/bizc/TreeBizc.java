package com.sgcc.exam.tree.bizc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgcc.uap.persistence.IHibernateDao;
import com.sgcc.uap.persistence.criterion.QueryCriteria;

public class TreeBizc implements ITreeBizc{

	@Autowired
	private IHibernateDao hibernateDao;
	
	
	/**
	 * 查询节点
	 * @return list
	 */
	public List listNode(Class clazz,String nodeValue,String pidName){
		
		QueryCriteria qc = new QueryCriteria();
		qc.addFrom(clazz.getName());
    	List list = null;
		if (pidName != null && pidName != "") {
    		if (nodeValue == null) {
    			qc.addWhere("",pidName, "is", null);
    		} else if (!nodeValue.equals("")) {
    			qc.addWhere("", pidName, "=", nodeValue);
    		}
		}
		list = hibernateDao.findAllByCriteria(qc);
		return list;
	}
	
	/**
	 * 查询根节点
	 * @param clazz
	 * @param pidName
	 * @return list
	 */
	public List listRoot(Class clazz,String pidName){
		return listNode(clazz, null, pidName);
	}
	
	/**
	 * 判断是否有子节点
	 */
	public boolean hasChild(String pid, Class childClazz, String pidName) {
		
		QueryCriteria qc = new QueryCriteria();
		qc.addFrom(childClazz.getName());
		if(pidName != null && pidName != "") {
			qc.addWhere(pidName + "= '"+ pid +"'");
		}
		qc.addPage(1,1,1);
		List list = hibernateDao.findAllByCriteria(qc);
		
		return (list != null && list.size() > 0);
	}

	public void setHibernateDao(IHibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
}
