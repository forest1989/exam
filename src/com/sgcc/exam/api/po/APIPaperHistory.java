package com.sgcc.exam.api.po;

import java.io.Serializable;
import java.util.Date;

public class APIPaperHistory implements Serializable{
	//试卷答题历史ID
	private int testPaperHistoryId;
	//用户编号
	private int mUserId;
	//试卷ID
	private int testPaperId;
	//答题分数
	private int mark;
	//删除标记
	private String delFlag;
	//创建时间
	private Date createDate;
	
	public APIPaperHistory(){}
	
	public int getTestPaperHistoryId() {
		return testPaperHistoryId;
	}
	public void setTestPaperHistoryId(int testPaperHistoryId) {
		this.testPaperHistoryId = testPaperHistoryId;
	}
	public int getmUserId() {
		return mUserId;
	}
	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}
	public int getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(int testPaperId) {
		this.testPaperId = testPaperId;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "APIPaperHistory [testPaperHistoryId=" + testPaperHistoryId + ", mUserId=" + mUserId + ", testPaperId="
				+ testPaperId + ", mark=" + mark + ", delFlag=" + delFlag + ", createDate=" + createDate + "]";
	}
	
	
}
