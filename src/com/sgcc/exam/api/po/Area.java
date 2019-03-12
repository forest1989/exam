package com.sgcc.exam.api.po;

import java.util.Date;

/**
 * Area
 * @author tyg
 * @date 2019-03-12
 */
public class Area implements java.io.Serializable {
	
	
    
	/** 区域ID*/
	
	private String areaId;
	
	/** 父级编号*/
	
	private String parentId;
	
	/** 所有父级编号*/
	
	private String parentIds;
	
	/** 区域名称*/
	
	private String areaName;
	
	/** 区域编码*/
	
	private String areaCode;
	
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
    public Area() {
    } 
    
		
	/** 构造方法 */
	public Area(String areaId) {
	    this.areaId = areaId;
	 }
	 	   
	
	
    public String getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
	
	
    public String getParentId() {
        return this.parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
	
	
    public String getParentIds() {
        return this.parentIds;
    }
    
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
	
	
    public String getAreaName() {
        return this.areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
	
	
    public String getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
		 buffer.append("areaId").append("='").append(getAreaId()).append("' ");			
		 buffer.append("parentId").append("='").append(getParentId()).append("' ");			
		 buffer.append("parentIds").append("='").append(getParentIds()).append("' ");			
		 buffer.append("areaName").append("='").append(getAreaName()).append("' ");			
		 buffer.append("areaCode").append("='").append(getAreaCode()).append("' ");			
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
		if ( !(other instanceof Area) ) return false;
		Area castOther = ( Area ) other; 
         
		return ( (this.getAreaId()==castOther.getAreaId()) || ( this.getAreaId()!=null && castOther.getAreaId()!=null && this.getAreaId().equals(castOther.getAreaId()) ) )
 && ( (this.getParentId()==castOther.getParentId()) || ( this.getParentId()!=null && castOther.getParentId()!=null && this.getParentId().equals(castOther.getParentId()) ) )
 && ( (this.getParentIds()==castOther.getParentIds()) || ( this.getParentIds()!=null && castOther.getParentIds()!=null && this.getParentIds().equals(castOther.getParentIds()) ) )
 && ( (this.getAreaName()==castOther.getAreaName()) || ( this.getAreaName()!=null && castOther.getAreaName()!=null && this.getAreaName().equals(castOther.getAreaName()) ) )
 && ( (this.getAreaCode()==castOther.getAreaCode()) || ( this.getAreaCode()!=null && castOther.getAreaCode()!=null && this.getAreaCode().equals(castOther.getAreaCode()) ) )
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
         
		result = 37 * result + ( getAreaId() == null ? 0 : this.getAreaId().hashCode() );
		result = 37 * result + ( getParentId() == null ? 0 : this.getParentId().hashCode() );
		result = 37 * result + ( getParentIds() == null ? 0 : this.getParentIds().hashCode() );
		result = 37 * result + ( getAreaName() == null ? 0 : this.getAreaName().hashCode() );
		result = 37 * result + ( getAreaCode() == null ? 0 : this.getAreaCode().hashCode() );
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
