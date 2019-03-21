package com.sgcc.exam.testJene.po;


/**
 * ManualRule
 * @author tyg
 * @date 2019-03-21
 */
public class ManualRule implements java.io.Serializable {
	
	
    
	/** 手动规则试卷内容*/
	
	private String manualRuleId;
	
	
	
	private TestPaper testpaper;
	
	/** 试题类型ID*/
	
	private String examTypeId;
	
	/** 试题ID集合*/
	
	private String examIds;
	
	/** 删除标记*/
	
	private String delFlag;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public ManualRule() {
    } 
    
		
	/** 构造方法 */
	public ManualRule(String manualRuleId) {
	    this.manualRuleId = manualRuleId;
	 }
	 	   
	
	
    public String getManualRuleId() {
        return this.manualRuleId;
    }
    
    public void setManualRuleId(String manualRuleId) {
        this.manualRuleId = manualRuleId;
    }
	
	
    public TestPaper getTestpaper() {
        return this.testpaper;
    }
    
    public void setTestpaper(TestPaper testpaper) {
        this.testpaper = testpaper;
    }
	
	
    public String getExamTypeId() {
        return this.examTypeId;
    }
    
    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId;
    }
	
	
    public String getExamIds() {
        return this.examIds;
    }
    
    public void setExamIds(String examIds) {
        this.examIds = examIds;
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
		 buffer.append("manualRuleId").append("='").append(getManualRuleId()).append("' ");			
		 buffer.append("testpaper").append("='").append(getTestpaper()).append("' ");			
		 buffer.append("examTypeId").append("='").append(getExamTypeId()).append("' ");			
		 buffer.append("examIds").append("='").append(getExamIds()).append("' ");			
		 buffer.append("delFlag").append("='").append(getDelFlag()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ManualRule) ) return false;
		ManualRule castOther = ( ManualRule ) other; 
         
		return ( (this.getManualRuleId()==castOther.getManualRuleId()) || ( this.getManualRuleId()!=null && castOther.getManualRuleId()!=null && this.getManualRuleId().equals(castOther.getManualRuleId()) ) )
 && ( (this.getTestpaper()==castOther.getTestpaper()) || ( this.getTestpaper()!=null && castOther.getTestpaper()!=null && this.getTestpaper().equals(castOther.getTestpaper()) ) )
 && ( (this.getExamTypeId()==castOther.getExamTypeId()) || ( this.getExamTypeId()!=null && castOther.getExamTypeId()!=null && this.getExamTypeId().equals(castOther.getExamTypeId()) ) )
 && ( (this.getExamIds()==castOther.getExamIds()) || ( this.getExamIds()!=null && castOther.getExamIds()!=null && this.getExamIds().equals(castOther.getExamIds()) ) )
 && ( (this.getDelFlag()==castOther.getDelFlag()) || ( this.getDelFlag()!=null && castOther.getDelFlag()!=null && this.getDelFlag().equals(castOther.getDelFlag()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getManualRuleId() == null ? 0 : this.getManualRuleId().hashCode() );
		result = 37 * result + ( getTestpaper() == null ? 0 : this.getTestpaper().hashCode() );
		result = 37 * result + ( getExamTypeId() == null ? 0 : this.getExamTypeId().hashCode() );
		result = 37 * result + ( getExamIds() == null ? 0 : this.getExamIds().hashCode() );
		result = 37 * result + ( getDelFlag() == null ? 0 : this.getDelFlag().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
