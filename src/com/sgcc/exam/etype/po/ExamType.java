package com.sgcc.exam.etype.po;

import java.util.Date;

/**
 * ExamType
 * @author forest
 * @date 2019-03-06
 */
public class ExamType implements java.io.Serializable {
	
	
    
	/** 试题分类ID*/
	
	private String examTypeId;
	
	/** 父级编号*/
	
	private String parentId;
	
	/** 分类名称*/
	
	private String typeName;
	
	/** 分类编码*/
	
	private String typeCode;
	
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
	
	/** 组织ID*/
	
	private String struId;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public ExamType() {
    } 
    
		
	/** 构造方法 */
	public ExamType(String examTypeId) {
	    this.examTypeId = examTypeId;
	 }
	 	   
	
	
    public String getExamTypeId() {
        return this.examTypeId;
    }
    
    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId;
    }
	
	
    public String getParentId() {
        return this.parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
	
	
    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
	
	
    public String getTypeCode() {
        return this.typeCode;
    }
    
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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
	
	
    public String getStruId() {
        return this.struId;
    }
    
    public void setStruId(String struId) {
        this.struId = struId;
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
		 buffer.append("examTypeId").append("='").append(getExamTypeId()).append("' ");			
		 buffer.append("parentId").append("='").append(getParentId()).append("' ");			
		 buffer.append("typeName").append("='").append(getTypeName()).append("' ");			
		 buffer.append("typeCode").append("='").append(getTypeCode()).append("' ");			
		 buffer.append("remarks").append("='").append(getRemarks()).append("' ");			
		 buffer.append("createDate").append("='").append(getCreateDate()).append("' ");			
		 buffer.append("createBy").append("='").append(getCreateBy()).append("' ");			
		 buffer.append("updateBy").append("='").append(getUpdateBy()).append("' ");			
		 buffer.append("updateDate").append("='").append(getUpdateDate()).append("' ");			
		 buffer.append("delFlag").append("='").append(getDelFlag()).append("' ");			
		 buffer.append("struId").append("='").append(getStruId()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ExamType) ) return false;
		ExamType castOther = ( ExamType ) other; 
         
		return ( (this.getExamTypeId()==castOther.getExamTypeId()) || ( this.getExamTypeId()!=null && castOther.getExamTypeId()!=null && this.getExamTypeId().equals(castOther.getExamTypeId()) ) )
 && ( (this.getParentId()==castOther.getParentId()) || ( this.getParentId()!=null && castOther.getParentId()!=null && this.getParentId().equals(castOther.getParentId()) ) )
 && ( (this.getTypeName()==castOther.getTypeName()) || ( this.getTypeName()!=null && castOther.getTypeName()!=null && this.getTypeName().equals(castOther.getTypeName()) ) )
 && ( (this.getTypeCode()==castOther.getTypeCode()) || ( this.getTypeCode()!=null && castOther.getTypeCode()!=null && this.getTypeCode().equals(castOther.getTypeCode()) ) )
 && ( (this.getRemarks()==castOther.getRemarks()) || ( this.getRemarks()!=null && castOther.getRemarks()!=null && this.getRemarks().equals(castOther.getRemarks()) ) )
 && ( (this.getCreateDate()==castOther.getCreateDate()) || ( this.getCreateDate()!=null && castOther.getCreateDate()!=null && this.getCreateDate().equals(castOther.getCreateDate()) ) )
 && ( (this.getCreateBy()==castOther.getCreateBy()) || ( this.getCreateBy()!=null && castOther.getCreateBy()!=null && this.getCreateBy().equals(castOther.getCreateBy()) ) )
 && ( (this.getUpdateBy()==castOther.getUpdateBy()) || ( this.getUpdateBy()!=null && castOther.getUpdateBy()!=null && this.getUpdateBy().equals(castOther.getUpdateBy()) ) )
 && ( (this.getUpdateDate()==castOther.getUpdateDate()) || ( this.getUpdateDate()!=null && castOther.getUpdateDate()!=null && this.getUpdateDate().equals(castOther.getUpdateDate()) ) )
 && ( (this.getDelFlag()==castOther.getDelFlag()) || ( this.getDelFlag()!=null && castOther.getDelFlag()!=null && this.getDelFlag().equals(castOther.getDelFlag()) ) )
 && ( (this.getStruId()==castOther.getStruId()) || ( this.getStruId()!=null && castOther.getStruId()!=null && this.getStruId().equals(castOther.getStruId()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getExamTypeId() == null ? 0 : this.getExamTypeId().hashCode() );
		result = 37 * result + ( getParentId() == null ? 0 : this.getParentId().hashCode() );
		result = 37 * result + ( getTypeName() == null ? 0 : this.getTypeName().hashCode() );
		result = 37 * result + ( getTypeCode() == null ? 0 : this.getTypeCode().hashCode() );
		result = 37 * result + ( getRemarks() == null ? 0 : this.getRemarks().hashCode() );
		result = 37 * result + ( getCreateDate() == null ? 0 : this.getCreateDate().hashCode() );
		result = 37 * result + ( getCreateBy() == null ? 0 : this.getCreateBy().hashCode() );
		result = 37 * result + ( getUpdateBy() == null ? 0 : this.getUpdateBy().hashCode() );
		result = 37 * result + ( getUpdateDate() == null ? 0 : this.getUpdateDate().hashCode() );
		result = 37 * result + ( getDelFlag() == null ? 0 : this.getDelFlag().hashCode() );
		result = 37 * result + ( getStruId() == null ? 0 : this.getStruId().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
