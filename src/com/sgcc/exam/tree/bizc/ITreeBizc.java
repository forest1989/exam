package com.sgcc.exam.tree.bizc;

import java.util.List;

import com.sgcc.exam.etype.po.ExamType;

public interface ITreeBizc {

	/**
	 * 查询节点
	 * @param clazz
	 * @param nodeValue
	 * @param pidName
	 * @return list
	 */
	public List listNode(Class clazz,String nodeValue,String pidName);
	
	/**
	 * 查询根节点
	 * @param clazz
	 * @param pidName
	 * @return list
	 */
	public List listRoot(Class clazz, String pidName);
	
	/**
	 * 判断是否有子节点
	 * @param pid
	 * @param childClazz
	 * @param pidName
	 * @return boolean
	 */
	public boolean hasChild(String pid, Class childClazz, String pidName);

	public ExamType getNode(String id);
}
