package com.sgcc.exam.testpaper.po;

import java.util.Date;

/**
 * TestPaper
 * @author Administrator
 * @date 2019-03-07
 */
public class APITestPaper implements java.io.Serializable {
	
	
    
	/** 试卷ID*/
	
	private Integer testPaperId;
	
	/** 试卷名称*/
	
	private String testPaperName;
	
	/** 区域ID*/
	
	private String areaId;
	
	/** 组织ID*/
	
	private String struId;
	
	/** 答题时间*/
	
	private Date answerTime;
	
	/** 试卷生成类型(自动手动)*/
	
	private String testPaperType;
	
	/** 备注*/
	
	private String remarks;
	
	/** 创建时间*/
	
	private Date createDate;
	
	/** 创建者*/
	
	private String createBy;
	
	/** 更新者*/
	
	private String updateBy;
	
	/** 更新时间*/
	
	private Date updateDate;
	
	/** 删除标记*/
	
	private String delFlag;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public APITestPaper() {
    } 
    
		
	/** 构造方法 */
	public APITestPaper(Integer testPaperId) {
	    this.testPaperId = testPaperId;
	 }
	 	   
	
	
    public Integer getTestPaperId() {
        return this.testPaperId;
    }
    
    public void setTestPaperId(Integer testPaperId) {
        this.testPaperId = testPaperId;
    }
	
	
    public String getTestPaperName() {
        return this.testPaperName;
    }
    
    public void setTestPaperName(String testPaperName) {
        this.testPaperName = testPaperName;
    }
	
	
    public String getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
	
	
    public String getStruId() {
        return this.struId;
    }
    
    public void setStruId(String struId) {
        this.struId = struId;
    }
	
	
    public Date getAnswerTime() {
        return this.answerTime;
    }
    
    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }
	
	
    public String getTestPaperType() {
        return this.testPaperType;
    }
    
    public void setTestPaperType(String testPaperType) {
        this.testPaperType = testPaperType;
    }
	
	
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	
	
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	
	
    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
	
	
    public String getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
	
	
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
	
	
    public String getDelFlag() {
        return this.delFlag;
    }
    
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
	
	
    public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    }
	

     public String toString() {
         StringBuffer buffer = new StringBuffer();

		 buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		 buffer.append("testPaperId").append("='").append(getTestPaperId()).append("' ");			
		 buffer.append("testPaperName").append("='").append(getTestPaperName()).append("' ");			
		 buffer.append("areaId").append("='").append(getAreaId()).append("' ");			
		 buffer.append("struId").append("='").append(getStruId()).append("' ");			
		 buffer.append("answerTime").append("='").append(getAnswerTime()).append("' ");			
		 buffer.append("testPaperType").append("='").append(getTestPaperType()).append("' ");			
		 buffer.append("remarks").append("='").append(getRemarks()).append("' ");			
		 buffer.append("createDate").append("='").append(getCreateDate()).append("' ");			
		 buffer.append("createBy").append("='").append(getCreateBy()).append("' ");			
		 buffer.append("updateBy").append("='").append(getUpdateBy()).append("' ");			
		 buffer.append("updateDate").append("='").append(getUpdateDate()).append("' ");			
		 buffer.append("delFlag").append("='").append(getDelFlag()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof APITestPaper) ) return false;
		APITestPaper castOther = ( APITestPaper ) other; 
         
		return ( (this.getTestPaperId()==castOther.getTestPaperId()) || ( this.getTestPaperId()!=null && castOther.getTestPaperId()!=null && this.getTestPaperId().equals(castOther.getTestPaperId()) ) )
 && ( (this.getTestPaperName()==castOther.getTestPaperName()) || ( this.getTestPaperName()!=null && castOther.getTestPaperName()!=null && this.getTestPaperName().equals(castOther.getTestPaperName()) ) )
 && ( (this.getAreaId()==castOther.getAreaId()) || ( this.getAreaId()!=null && castOther.getAreaId()!=null && this.getAreaId().equals(castOther.getAreaId()) ) )
 && ( (this.getStruId()==castOther.getStruId()) || ( this.getStruId()!=null && castOther.getStruId()!=null && this.getStruId().equals(castOther.getStruId()) ) )
 && ( (this.getAnswerTime()==castOther.getAnswerTime()) || ( this.getAnswerTime()!=null && castOther.getAnswerTime()!=null && this.getAnswerTime().equals(castOther.getAnswerTime()) ) )
 && ( (this.getTestPaperType()==castOther.getTestPaperType()) || ( this.getTestPaperType()!=null && castOther.getTestPaperType()!=null && this.getTestPaperType().equals(castOther.getTestPaperType()) ) )
 && ( (this.getRemarks()==castOther.getRemarks()) || ( this.getRemarks()!=null && castOther.getRemarks()!=null && this.getRemarks().equals(castOther.getRemarks()) ) )
 && ( (this.getCreateDate()==castOther.getCreateDate()) || ( this.getCreateDate()!=null && castOther.getCreateDate()!=null && this.getCreateDate().equals(castOther.getCreateDate()) ) )
 && ( (this.getCreateBy()==castOther.getCreateBy()) || ( this.getCreateBy()!=null && castOther.getCreateBy()!=null && this.getCreateBy().equals(castOther.getCreateBy()) ) )
 && ( (this.getUpdateBy()==castOther.getUpdateBy()) || ( this.getUpdateBy()!=null && castOther.getUpdateBy()!=null && this.getUpdateBy().equals(castOther.getUpdateBy()) ) )
 && ( (this.getUpdateDate()==castOther.getUpdateDate()) || ( this.getUpdateDate()!=null && castOther.getUpdateDate()!=null && this.getUpdateDate().equals(castOther.getUpdateDate()) ) )
 && ( (this.getDelFlag()==castOther.getDelFlag()) || ( this.getDelFlag()!=null && castOther.getDelFlag()!=null && this.getDelFlag().equals(castOther.getDelFlag()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getTestPaperId() == null ? 0 : this.getTestPaperId().hashCode() );
		result = 37 * result + ( getTestPaperName() == null ? 0 : this.getTestPaperName().hashCode() );
		result = 37 * result + ( getAreaId() == null ? 0 : this.getAreaId().hashCode() );
		result = 37 * result + ( getStruId() == null ? 0 : this.getStruId().hashCode() );
		result = 37 * result + ( getAnswerTime() == null ? 0 : this.getAnswerTime().hashCode() );
		result = 37 * result + ( getTestPaperType() == null ? 0 : this.getTestPaperType().hashCode() );
		result = 37 * result + ( getRemarks() == null ? 0 : this.getRemarks().hashCode() );
		result = 37 * result + ( getCreateDate() == null ? 0 : this.getCreateDate().hashCode() );
		result = 37 * result + ( getCreateBy() == null ? 0 : this.getCreateBy().hashCode() );
		result = 37 * result + ( getUpdateBy() == null ? 0 : this.getUpdateBy().hashCode() );
		result = 37 * result + ( getUpdateDate() == null ? 0 : this.getUpdateDate().hashCode() );
		result = 37 * result + ( getDelFlag() == null ? 0 : this.getDelFlag().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
