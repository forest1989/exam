package com.sgcc.exam.examInfo.po;

import java.util.Date;

/**
 * Examinfo
 * @author tyg
 * @date 2019-03-06
 */
public class Examinfo implements java.io.Serializable {
	
	
    
	/** 试题ID*/
	
	private Integer examId;
	
	/** 组织ID*/
	
	private String struId;
	
	/** 区域ID*/
	
	private String areaId;
	
	/** 阅读内容ID*/
	
	private String readingId;
	
	/** 试题内容(文本)*/
	
	private String examContentText;
	
	/** 试题内容(图片)*/
	
	private String examContentImg;
	
	/** 试题答案*/
	
	private String examAnswer;
	
	/** 答案解析*/
	
	private String answerAnalyze;
	
	/** 试题类型单选多选*/
	
	private String examSubject;
	
	/** 难易程度难度等级暂定*/
	
	private String examGrades;
	
	/** 试题分数*/
	
	private String examMark;
	
	/** 试题分类ID*/
	
	private String examTypeId;
	
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

    /** 无参构造方法 */
    public Examinfo() {
    } 
    
		
	public String getOptionsAText() {
		return optionsAText;
	}


	public void setOptionsAText(String optionsAText) {
		this.optionsAText = optionsAText;
	}


	public String getOptionsAImg() {
		return optionsAImg;
	}


	public void setOptionsAImg(String optionsAImg) {
		this.optionsAImg = optionsAImg;
	}


	public String getOptionsBText() {
		return optionsBText;
	}


	public void setOptionsBText(String optionsBText) {
		this.optionsBText = optionsBText;
	}


	public String getOptionsBImg() {
		return optionsBImg;
	}


	public void setOptionsBImg(String optionsBImg) {
		this.optionsBImg = optionsBImg;
	}


	public String getOptionsCText() {
		return optionsCText;
	}


	public void setOptionsCText(String optionsCText) {
		this.optionsCText = optionsCText;
	}


	public String getOptionsCImg() {
		return optionsCImg;
	}


	public void setOptionsCImg(String optionsCImg) {
		this.optionsCImg = optionsCImg;
	}


	public String getOptionsDText() {
		return optionsDText;
	}


	public void setOptionsDText(String optionsDText) {
		this.optionsDText = optionsDText;
	}


	public String getOptionsDImg() {
		return optionsDImg;
	}


	public void setOptionsDImg(String optionsDImg) {
		this.optionsDImg = optionsDImg;
	}


	public String getOptionsEText() {
		return optionsEText;
	}


	public void setOptionsEText(String optionsEText) {
		this.optionsEText = optionsEText;
	}


	public String getOptionsEImg() {
		return optionsEImg;
	}


	public void setOptionsEImg(String optionsEImg) {
		this.optionsEImg = optionsEImg;
	}


	public String getOptionsFText() {
		return optionsFText;
	}


	public void setOptionsFText(String optionsFText) {
		this.optionsFText = optionsFText;
	}


	public String getOptionsFImg() {
		return optionsFImg;
	}


	public void setOptionsFImg(String optionsFImg) {
		this.optionsFImg = optionsFImg;
	}


	/** 构造方法 */
	public Examinfo(Integer examId) {
	    this.examId = examId;
	 }
	 	   
	
	
    public Integer getExamId() {
        return this.examId;
    }
    
    public void setExamId(Integer examId) {
        this.examId = examId;
    }
	
	
    public String getStruId() {
        return this.struId;
    }
    
    public void setStruId(String struId) {
        this.struId = struId;
    }
	
	
    public String getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
	
	
    public String getReadingId() {
        return this.readingId;
    }
    
    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }
	
	
    public String getExamContentText() {
        return this.examContentText;
    }
    
    public void setExamContentText(String examContentText) {
        this.examContentText = examContentText;
    }
	
	
    public String getExamContentImg() {
        return this.examContentImg;
    }
    
    public void setExamContentImg(String examContentImg) {
        this.examContentImg = examContentImg;
    }
	
	
    public String getExamAnswer() {
        return this.examAnswer;
    }
    
    public void setExamAnswer(String examAnswer) {
        this.examAnswer = examAnswer;
    }
	
	
    public String getAnswerAnalyze() {
        return this.answerAnalyze;
    }
    
    public void setAnswerAnalyze(String answerAnalyze) {
        this.answerAnalyze = answerAnalyze;
    }
	
	
    public String getExamSubject() {
        return this.examSubject;
    }
    
    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }
	
	
    public String getExamGrades() {
        return this.examGrades;
    }
    
    public void setExamGrades(String examGrades) {
        this.examGrades = examGrades;
    }
	
	
    public String getExamMark() {
        return this.examMark;
    }
    
    public void setExamMark(String examMark) {
        this.examMark = examMark;
    }
	
	
    public String getExamTypeId() {
        return this.examTypeId;
    }
    
    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId;
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
		 buffer.append("examId").append("='").append(getExamId()).append("' ");			
		 buffer.append("struId").append("='").append(getStruId()).append("' ");			
		 buffer.append("areaId").append("='").append(getAreaId()).append("' ");			
		 buffer.append("readingId").append("='").append(getReadingId()).append("' ");			
		 buffer.append("examContentText").append("='").append(getExamContentText()).append("' ");			
		 buffer.append("examContentImg").append("='").append(getExamContentImg()).append("' ");			
		 buffer.append("examAnswer").append("='").append(getExamAnswer()).append("' ");			
		 buffer.append("answerAnalyze").append("='").append(getAnswerAnalyze()).append("' ");			
		 buffer.append("examSubject").append("='").append(getExamSubject()).append("' ");			
		 buffer.append("examGrades").append("='").append(getExamGrades()).append("' ");			
		 buffer.append("examMark").append("='").append(getExamMark()).append("' ");			
		 buffer.append("examTypeId").append("='").append(getExamTypeId()).append("' ");			
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
		if ( !(other instanceof Examinfo) ) return false;
		Examinfo castOther = ( Examinfo ) other; 
         
		return ( (this.getExamId()==castOther.getExamId()) || ( this.getExamId()!=null && castOther.getExamId()!=null && this.getExamId().equals(castOther.getExamId()) ) )
 && ( (this.getStruId()==castOther.getStruId()) || ( this.getStruId()!=null && castOther.getStruId()!=null && this.getStruId().equals(castOther.getStruId()) ) )
 && ( (this.getAreaId()==castOther.getAreaId()) || ( this.getAreaId()!=null && castOther.getAreaId()!=null && this.getAreaId().equals(castOther.getAreaId()) ) )
 && ( (this.getReadingId()==castOther.getReadingId()) || ( this.getReadingId()!=null && castOther.getReadingId()!=null && this.getReadingId().equals(castOther.getReadingId()) ) )
 && ( (this.getExamContentText()==castOther.getExamContentText()) || ( this.getExamContentText()!=null && castOther.getExamContentText()!=null && this.getExamContentText().equals(castOther.getExamContentText()) ) )
 && ( (this.getExamContentImg()==castOther.getExamContentImg()) || ( this.getExamContentImg()!=null && castOther.getExamContentImg()!=null && this.getExamContentImg().equals(castOther.getExamContentImg()) ) )
 && ( (this.getExamAnswer()==castOther.getExamAnswer()) || ( this.getExamAnswer()!=null && castOther.getExamAnswer()!=null && this.getExamAnswer().equals(castOther.getExamAnswer()) ) )
 && ( (this.getAnswerAnalyze()==castOther.getAnswerAnalyze()) || ( this.getAnswerAnalyze()!=null && castOther.getAnswerAnalyze()!=null && this.getAnswerAnalyze().equals(castOther.getAnswerAnalyze()) ) )
 && ( (this.getExamSubject()==castOther.getExamSubject()) || ( this.getExamSubject()!=null && castOther.getExamSubject()!=null && this.getExamSubject().equals(castOther.getExamSubject()) ) )
 && ( (this.getExamGrades()==castOther.getExamGrades()) || ( this.getExamGrades()!=null && castOther.getExamGrades()!=null && this.getExamGrades().equals(castOther.getExamGrades()) ) )
 && ( (this.getExamMark()==castOther.getExamMark()) || ( this.getExamMark()!=null && castOther.getExamMark()!=null && this.getExamMark().equals(castOther.getExamMark()) ) )
 && ( (this.getExamTypeId()==castOther.getExamTypeId()) || ( this.getExamTypeId()!=null && castOther.getExamTypeId()!=null && this.getExamTypeId().equals(castOther.getExamTypeId()) ) )
 && ( (this.getCreateDate()==castOther.getCreateDate()) || ( this.getCreateDate()!=null && castOther.getCreateDate()!=null && this.getCreateDate().equals(castOther.getCreateDate()) ) )
 && ( (this.getCreateBy()==castOther.getCreateBy()) || ( this.getCreateBy()!=null && castOther.getCreateBy()!=null && this.getCreateBy().equals(castOther.getCreateBy()) ) )
 && ( (this.getUpdateBy()==castOther.getUpdateBy()) || ( this.getUpdateBy()!=null && castOther.getUpdateBy()!=null && this.getUpdateBy().equals(castOther.getUpdateBy()) ) )
 && ( (this.getUpdateDate()==castOther.getUpdateDate()) || ( this.getUpdateDate()!=null && castOther.getUpdateDate()!=null && this.getUpdateDate().equals(castOther.getUpdateDate()) ) )
 && ( (this.getDelFlag()==castOther.getDelFlag()) || ( this.getDelFlag()!=null && castOther.getDelFlag()!=null && this.getDelFlag().equals(castOther.getDelFlag()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getExamId() == null ? 0 : this.getExamId().hashCode() );
		result = 37 * result + ( getStruId() == null ? 0 : this.getStruId().hashCode() );
		result = 37 * result + ( getAreaId() == null ? 0 : this.getAreaId().hashCode() );
		result = 37 * result + ( getReadingId() == null ? 0 : this.getReadingId().hashCode() );
		result = 37 * result + ( getExamContentText() == null ? 0 : this.getExamContentText().hashCode() );
		result = 37 * result + ( getExamContentImg() == null ? 0 : this.getExamContentImg().hashCode() );
		result = 37 * result + ( getExamAnswer() == null ? 0 : this.getExamAnswer().hashCode() );
		result = 37 * result + ( getAnswerAnalyze() == null ? 0 : this.getAnswerAnalyze().hashCode() );
		result = 37 * result + ( getExamSubject() == null ? 0 : this.getExamSubject().hashCode() );
		result = 37 * result + ( getExamGrades() == null ? 0 : this.getExamGrades().hashCode() );
		result = 37 * result + ( getExamMark() == null ? 0 : this.getExamMark().hashCode() );
		result = 37 * result + ( getExamTypeId() == null ? 0 : this.getExamTypeId().hashCode() );
		result = 37 * result + ( getCreateDate() == null ? 0 : this.getCreateDate().hashCode() );
		result = 37 * result + ( getCreateBy() == null ? 0 : this.getCreateBy().hashCode() );
		result = 37 * result + ( getUpdateBy() == null ? 0 : this.getUpdateBy().hashCode() );
		result = 37 * result + ( getUpdateDate() == null ? 0 : this.getUpdateDate().hashCode() );
		result = 37 * result + ( getDelFlag() == null ? 0 : this.getDelFlag().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
