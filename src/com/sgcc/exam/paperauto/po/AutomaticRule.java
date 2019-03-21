package com.sgcc.exam.paperauto.po;


/**
 * AutomaticRule
 * @author Administrator
 * @date 2019-03-20
 */
public class AutomaticRule implements java.io.Serializable {
	
	
    
	/** 自动规则试卷内容*/
	
	private String automaticRuleId;
	
	
	
	private TestPaper testpaper;
	
	/** 试题类型ID*/
	
	private String examTypeId;
	
	/** 试题道数*/
	
	private String examCount;
	
	/** 删除标记*/
	
	private String delFlag;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public AutomaticRule() {
    } 
    
		
	/** 构造方法 */
	public AutomaticRule(String automaticRuleId) {
	    this.automaticRuleId = automaticRuleId;
	 }
	 	   
	
	
    public String getAutomaticRuleId() {
        return this.automaticRuleId;
    }
    
    public void setAutomaticRuleId(String automaticRuleId) {
        this.automaticRuleId = automaticRuleId;
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
	
	
    public String getExamCount() {
        return this.examCount;
    }
    
    public void setExamCount(String examCount) {
        this.examCount = examCount;
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
		 buffer.append("automaticRuleId").append("='").append(getAutomaticRuleId()).append("' ");			
		 buffer.append("testpaper").append("='").append(getTestpaper()).append("' ");			
		 buffer.append("examTypeId").append("='").append(getExamTypeId()).append("' ");			
		 buffer.append("examCount").append("='").append(getExamCount()).append("' ");			
		 buffer.append("delFlag").append("='").append(getDelFlag()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof AutomaticRule) ) return false;
		AutomaticRule castOther = ( AutomaticRule ) other; 
         
		return ( (this.getAutomaticRuleId()==castOther.getAutomaticRuleId()) || ( this.getAutomaticRuleId()!=null && castOther.getAutomaticRuleId()!=null && this.getAutomaticRuleId().equals(castOther.getAutomaticRuleId()) ) )
 && ( (this.getTestpaper()==castOther.getTestpaper()) || ( this.getTestpaper()!=null && castOther.getTestpaper()!=null && this.getTestpaper().equals(castOther.getTestpaper()) ) )
 && ( (this.getExamTypeId()==castOther.getExamTypeId()) || ( this.getExamTypeId()!=null && castOther.getExamTypeId()!=null && this.getExamTypeId().equals(castOther.getExamTypeId()) ) )
 && ( (this.getExamCount()==castOther.getExamCount()) || ( this.getExamCount()!=null && castOther.getExamCount()!=null && this.getExamCount().equals(castOther.getExamCount()) ) )
 && ( (this.getDelFlag()==castOther.getDelFlag()) || ( this.getDelFlag()!=null && castOther.getDelFlag()!=null && this.getDelFlag().equals(castOther.getDelFlag()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getAutomaticRuleId() == null ? 0 : this.getAutomaticRuleId().hashCode() );
		result = 37 * result + ( getTestpaper() == null ? 0 : this.getTestpaper().hashCode() );
		result = 37 * result + ( getExamTypeId() == null ? 0 : this.getExamTypeId().hashCode() );
		result = 37 * result + ( getExamCount() == null ? 0 : this.getExamCount().hashCode() );
		result = 37 * result + ( getDelFlag() == null ? 0 : this.getDelFlag().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
