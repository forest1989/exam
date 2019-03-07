package com.sgcc.exam.examInfo.po;


/**
 * ExamOptions
 * @author tyg
 * @date 2019-03-07
 */
public class ExamOptions implements java.io.Serializable {
	
	
    
	/** 试题选项ID*/
	
	private Integer optionsId;
	
	
	
/** 试题ID*/
	
	private Integer examId;
	
	/** 试题选项A内容(文本)*/
	
	private String optionsAText;
	
	/** 试题选项A内容((图片)*/
	
	private String optionsAImg;
	
	/** 试题选项B内容(文本)*/
	
	private String optionsBText;
	
	/** 试题选项B内容((图片)*/
	
	private String optionsBImg;
	
	/** 试题选项C内容(文本)*/
	
	private String optionsCText;
	
	/** 试题选项C内容((图片)*/
	
	private String optionsCImg;
	
	/** 试题选项D内容(文本)*/
	
	private String optionsDText;
	
	/** 试题选项D内容((图片)*/
	
	private String optionsDImg;
	
	/** 试题选项E内容(文本)*/
	
	private String optionsEText;
	
	/** 试题选项E内容((图片)*/
	
	private String optionsEImg;
	
	/** 试题选项F内容(文本)*/
	
	private String optionsFText;
	
	/** 试题选项F内容((图片)*/
	
	private String optionsFImg;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public ExamOptions() {
    } 
    
		
	/** 构造方法 */
	public ExamOptions(Integer optionsId) {
	    this.optionsId = optionsId;
	 }
	 	   
	
	
    public Integer getOptionsId() {
        return this.optionsId;
    }
    
    public void setOptionsId(Integer optionsId) {
        this.optionsId = optionsId;
    }
	
	
  
	
	
    public Integer getExamId() {
		return examId;
	}


	public void setExamId(Integer examId) {
		this.examId = examId;
	}


	public String getOptionsAText() {
        return this.optionsAText;
    }
    
    public void setOptionsAText(String optionsAText) {
        this.optionsAText = optionsAText;
    }
	
	
    public String getOptionsAImg() {
        return this.optionsAImg;
    }
    
    public void setOptionsAImg(String optionsAImg) {
        this.optionsAImg = optionsAImg;
    }
	
	
    public String getOptionsBText() {
        return this.optionsBText;
    }
    
    public void setOptionsBText(String optionsBText) {
        this.optionsBText = optionsBText;
    }
	
	
    public String getOptionsBImg() {
        return this.optionsBImg;
    }
    
    public void setOptionsBImg(String optionsBImg) {
        this.optionsBImg = optionsBImg;
    }
	
	
    public String getOptionsCText() {
        return this.optionsCText;
    }
    
    public void setOptionsCText(String optionsCText) {
        this.optionsCText = optionsCText;
    }
	
	
    public String getOptionsCImg() {
        return this.optionsCImg;
    }
    
    public void setOptionsCImg(String optionsCImg) {
        this.optionsCImg = optionsCImg;
    }
	
	
    public String getOptionsDText() {
        return this.optionsDText;
    }
    
    public void setOptionsDText(String optionsDText) {
        this.optionsDText = optionsDText;
    }
	
	
    public String getOptionsDImg() {
        return this.optionsDImg;
    }
    
    public void setOptionsDImg(String optionsDImg) {
        this.optionsDImg = optionsDImg;
    }
	
	
    public String getOptionsEText() {
        return this.optionsEText;
    }
    
    public void setOptionsEText(String optionsEText) {
        this.optionsEText = optionsEText;
    }
	
	
    public String getOptionsEImg() {
        return this.optionsEImg;
    }
    
    public void setOptionsEImg(String optionsEImg) {
        this.optionsEImg = optionsEImg;
    }
	
	
    public String getOptionsFText() {
        return this.optionsFText;
    }
    
    public void setOptionsFText(String optionsFText) {
        this.optionsFText = optionsFText;
    }
	
	
    public String getOptionsFImg() {
        return this.optionsFImg;
    }
    
    public void setOptionsFImg(String optionsFImg) {
        this.optionsFImg = optionsFImg;
    }
	
	
    public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    }
	


	@Override
	public String toString() {
		return "ExamOptions [optionsId=" + optionsId + ", examId=" + examId + ", optionsAText=" + optionsAText
				+ ", optionsAImg=" + optionsAImg + ", optionsBText=" + optionsBText + ", optionsBImg=" + optionsBImg
				+ ", optionsCText=" + optionsCText + ", optionsCImg=" + optionsCImg + ", optionsDText=" + optionsDText
				+ ", optionsDImg=" + optionsDImg + ", optionsEText=" + optionsEText + ", optionsEImg=" + optionsEImg
				+ ", optionsFText=" + optionsFText + ", optionsFImg=" + optionsFImg + ", mxVirtualId=" + mxVirtualId
				+ "]";
	}


	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ExamOptions) ) return false;
		ExamOptions castOther = ( ExamOptions ) other; 
         
		return ( (this.getOptionsId()==castOther.getOptionsId()) || ( this.getOptionsId()!=null && castOther.getOptionsId()!=null && this.getOptionsId().equals(castOther.getOptionsId()) ) )
 
 && ( (this.getOptionsAText()==castOther.getOptionsAText()) || ( this.getOptionsAText()!=null && castOther.getOptionsAText()!=null && this.getOptionsAText().equals(castOther.getOptionsAText()) ) )
 && ( (this.getOptionsAImg()==castOther.getOptionsAImg()) || ( this.getOptionsAImg()!=null && castOther.getOptionsAImg()!=null && this.getOptionsAImg().equals(castOther.getOptionsAImg()) ) )
 && ( (this.getOptionsBText()==castOther.getOptionsBText()) || ( this.getOptionsBText()!=null && castOther.getOptionsBText()!=null && this.getOptionsBText().equals(castOther.getOptionsBText()) ) )
 && ( (this.getOptionsBImg()==castOther.getOptionsBImg()) || ( this.getOptionsBImg()!=null && castOther.getOptionsBImg()!=null && this.getOptionsBImg().equals(castOther.getOptionsBImg()) ) )
 && ( (this.getOptionsCText()==castOther.getOptionsCText()) || ( this.getOptionsCText()!=null && castOther.getOptionsCText()!=null && this.getOptionsCText().equals(castOther.getOptionsCText()) ) )
 && ( (this.getOptionsCImg()==castOther.getOptionsCImg()) || ( this.getOptionsCImg()!=null && castOther.getOptionsCImg()!=null && this.getOptionsCImg().equals(castOther.getOptionsCImg()) ) )
 && ( (this.getOptionsDText()==castOther.getOptionsDText()) || ( this.getOptionsDText()!=null && castOther.getOptionsDText()!=null && this.getOptionsDText().equals(castOther.getOptionsDText()) ) )
 && ( (this.getOptionsDImg()==castOther.getOptionsDImg()) || ( this.getOptionsDImg()!=null && castOther.getOptionsDImg()!=null && this.getOptionsDImg().equals(castOther.getOptionsDImg()) ) )
 && ( (this.getOptionsEText()==castOther.getOptionsEText()) || ( this.getOptionsEText()!=null && castOther.getOptionsEText()!=null && this.getOptionsEText().equals(castOther.getOptionsEText()) ) )
 && ( (this.getOptionsEImg()==castOther.getOptionsEImg()) || ( this.getOptionsEImg()!=null && castOther.getOptionsEImg()!=null && this.getOptionsEImg().equals(castOther.getOptionsEImg()) ) )
 && ( (this.getOptionsFText()==castOther.getOptionsFText()) || ( this.getOptionsFText()!=null && castOther.getOptionsFText()!=null && this.getOptionsFText().equals(castOther.getOptionsFText()) ) )
 && ( (this.getOptionsFImg()==castOther.getOptionsFImg()) || ( this.getOptionsFImg()!=null && castOther.getOptionsFImg()!=null && this.getOptionsFImg().equals(castOther.getOptionsFImg()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getOptionsId() == null ? 0 : this.getOptionsId().hashCode() );
		result = 37 * result + ( getOptionsAText() == null ? 0 : this.getOptionsAText().hashCode() );
		result = 37 * result + ( getOptionsAImg() == null ? 0 : this.getOptionsAImg().hashCode() );
		result = 37 * result + ( getOptionsBText() == null ? 0 : this.getOptionsBText().hashCode() );
		result = 37 * result + ( getOptionsBImg() == null ? 0 : this.getOptionsBImg().hashCode() );
		result = 37 * result + ( getOptionsCText() == null ? 0 : this.getOptionsCText().hashCode() );
		result = 37 * result + ( getOptionsCImg() == null ? 0 : this.getOptionsCImg().hashCode() );
		result = 37 * result + ( getOptionsDText() == null ? 0 : this.getOptionsDText().hashCode() );
		result = 37 * result + ( getOptionsDImg() == null ? 0 : this.getOptionsDImg().hashCode() );
		result = 37 * result + ( getOptionsEText() == null ? 0 : this.getOptionsEText().hashCode() );
		result = 37 * result + ( getOptionsEImg() == null ? 0 : this.getOptionsEImg().hashCode() );
		result = 37 * result + ( getOptionsFText() == null ? 0 : this.getOptionsFText().hashCode() );
		result = 37 * result + ( getOptionsFImg() == null ? 0 : this.getOptionsFImg().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
