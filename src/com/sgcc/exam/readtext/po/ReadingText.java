package com.sgcc.exam.readtext.po;

import java.util.Date;

/**
 * ReadingText
 * @author admin
 * @date 2019-03-11
 */
public class ReadingText implements java.io.Serializable {
	
	
    
	/** 阅读内容ID*/
	
	private Integer readingId;
	
	/** 阅读内容编码*/
	
	private String readingCode;
	
	/** 阅读图片内容*/
	
	private String readingImg;
	
	/** 阅读文本内容*/
	
	private String readingText;
	
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
    public ReadingText() {
    } 
    
		
	/** 构造方法 */
	public ReadingText(Integer readingId) {
	    this.readingId = readingId;
	 }
	 	   
	
	
    public Integer getReadingId() {
        return this.readingId;
    }
    
    public void setReadingId(Integer readingId) {
        this.readingId = readingId;
    }
	
	
    public String getReadingCode() {
        return this.readingCode;
    }
    
    public void setReadingCode(String readingCode) {
        this.readingCode = readingCode;
    }
	
	
    public String getReadingImg() {
        return this.readingImg;
    }
    
    public void setReadingImg(String readingImg) {
        this.readingImg = readingImg;
    }
	
	
    public String getReadingText() {
        return this.readingText;
    }
    
    public void setReadingText(String readingText) {
        this.readingText = readingText;
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
		 buffer.append("readingId").append("='").append(getReadingId()).append("' ");			
		 buffer.append("readingCode").append("='").append(getReadingCode()).append("' ");			
		 buffer.append("readingImg").append("='").append(getReadingImg()).append("' ");			
		 buffer.append("readingText").append("='").append(getReadingText()).append("' ");			
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
		if ( !(other instanceof ReadingText) ) return false;
		ReadingText castOther = ( ReadingText ) other; 
         
		return ( (this.getReadingId()==castOther.getReadingId()) || ( this.getReadingId()!=null && castOther.getReadingId()!=null && this.getReadingId().equals(castOther.getReadingId()) ) )
 && ( (this.getReadingCode()==castOther.getReadingCode()) || ( this.getReadingCode()!=null && castOther.getReadingCode()!=null && this.getReadingCode().equals(castOther.getReadingCode()) ) )
 && ( (this.getReadingImg()==castOther.getReadingImg()) || ( this.getReadingImg()!=null && castOther.getReadingImg()!=null && this.getReadingImg().equals(castOther.getReadingImg()) ) )
 && ( (this.getReadingText()==castOther.getReadingText()) || ( this.getReadingText()!=null && castOther.getReadingText()!=null && this.getReadingText().equals(castOther.getReadingText()) ) )
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
         
		result = 37 * result + ( getReadingId() == null ? 0 : this.getReadingId().hashCode() );
		result = 37 * result + ( getReadingCode() == null ? 0 : this.getReadingCode().hashCode() );
		result = 37 * result + ( getReadingImg() == null ? 0 : this.getReadingImg().hashCode() );
		result = 37 * result + ( getReadingText() == null ? 0 : this.getReadingText().hashCode() );
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
