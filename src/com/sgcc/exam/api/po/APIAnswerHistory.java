package com.sgcc.exam.api.po;

import java.io.Serializable;
import java.util.Date;

public class APIAnswerHistory implements Serializable{
	//答题历史ID
	private Integer answerHistoryId;
	//用户编号
	private int mUserId;
	//试题ID
	private int examId;
	//试卷ID
	private int testPaperId;
	//用户答案选项
	private String answerOptions;
	//试卷分类ID
	private  int examTypeId;
	//答题结果 1：对 0：错
	private String answerResult;
	//删除标记
	private String delFlag;
	//创建时间
	private Date createDate;
	
	public APIAnswerHistory(){}
	
	public Integer getAnswerHistoryId() {
		return answerHistoryId;
	}
	public void setAnswerHistoryId(Integer answerHistoryId) {
		this.answerHistoryId = answerHistoryId;
	}
	public int getmUserId() {
		return mUserId;
	}
	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(int testPaperId) {
		this.testPaperId = testPaperId;
	}
	public String getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(String answerOptions) {
		this.answerOptions = answerOptions;
	}
	public int getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}
	public String getAnswerResult() {
		return answerResult;
	}
	public void setAnswerResult(String answerResult) {
		this.answerResult = answerResult;
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
		return "APIAnswerHistory [answerHistoryId=" + answerHistoryId + ", mUserId=" + mUserId + ", examId=" + examId
				+ ", testPaperId=" + testPaperId + ", answerOptions=" + answerOptions + ", examTypeId=" + examTypeId
				+ ", answerResult=" + answerResult + ", delFlag=" + delFlag + ", createDate=" + createDate + "]";
	}
}
