package com.sgcc.exam.tree;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.exam.tree.bizc.ITreeBizc;
import com.sgcc.uap.rest.annotation.ItemRequestParam;
import com.sgcc.uap.rest.annotation.TreeResponseBody;
import com.sgcc.uap.rest.support.TreeNode;

@Controller
@RequestMapping("/examTypeTree")
public class ExamTypeTreeController {

	@Resource
	private ITreeBizc treeBizc;
	
	/**
	 * 获取根节点
	 * 
	 * @return nodelist
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public @TreeResponseBody List<TreeNode> getRoot() {

		List<ExamType> list = treeBizc.listRoot(ExamType.class, "parentId");
		List<TreeNode> nodelist = new ArrayList<TreeNode>();
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = new TreeNode();
			ExamType examType = (ExamType) list.get(i);
			node.setId(examType.getExamTypeId().toString()); // 主键的get方法
			boolean hasChild = treeBizc.hasChild(examType.getExamTypeId().toString(), ExamType.class, "parentId");
			node.setHasChildren(hasChild);
			node.setText(examType.getTypeName());// 显示字段的get方法
			node.setItemType("examType"); // 根节点的itemType
			nodelist.add(node);
		}
		return nodelist;
	}


	
	/**
	 * 获取指定id的下级节点
	 * 
	 * @param id
	 * 
	 * @return nodelist
	 */
	@RequestMapping(value = "/tree/{id}", method = RequestMethod.GET)
	public @TreeResponseBody List<TreeNode> getNodes(@PathVariable String id,
			@ItemRequestParam("params") String itemType) {

		List<TreeNode> nodelist = new ArrayList<TreeNode>();
		List<String> itemTypeList = this.getItemTypes(itemType);
		for (int i = 0; i < itemTypeList.size(); i++) {
			String itemtype = (String) itemTypeList.get(i);

			if ("examType".equals(itemtype)) {
				nodelist.addAll(this.getExamTypeList(id, itemtype));
			}
			
		}
		return nodelist;
	}
	
	private List<TreeNode> getExamTypeList(String id, String itemType) {

		List<TreeNode> nodelist = new ArrayList<TreeNode>();

		// ExamType中取出下级节点
		List<ExamType> departmentList = treeBizc.listNode(ExamType.class, id, "parentId");
		for (int i = 0; i < departmentList.size(); i++) {
			TreeNode treeNode = new TreeNode();
			ExamType examType = (ExamType) departmentList.get(i);
			treeNode.setId(examType.getExamTypeId().toString());
			boolean hasChild = treeBizc.hasChild((examType.getExamTypeId().toString()), ExamType.class, "parentId");
			treeNode.setHasChildren(hasChild);
			treeNode.setText(examType.getTypeName()); // 显示字段
			treeNode.setItemType(itemType);
			nodelist.add(treeNode);
		}
		return nodelist;
	}
	
	/*
	 * 获取itemType集合
	 */
	private List<String> getItemTypes(String itemtype) {
		List<String> list = new ArrayList<String>();
		if ("examType".equals(itemtype)) {
			list.add("examType");
		}
		return list;
	}
}
