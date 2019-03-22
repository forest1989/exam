package com.sgcc.exam.wxImages.po;


/**
 * 微信图标
 * @author hao
 * @date 2019-03-22
 */
public class WxImageConf implements java.io.Serializable {
	
	
    
	/** 图标序列*/
	
	private Integer id;
	
	/** 图标标识*/
	
	private String wxIdentify;
	
	/** 图标名称*/
	
	private String wxImage;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public WxImageConf() {
    } 
    
		
	/** 构造方法 */
	public WxImageConf(Integer id) {
	    this.id = id;
	 }
	 	   
	
	
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
	
	
    public String getWxIdentify() {
        return this.wxIdentify;
    }
    
    public void setWxIdentify(String wxIdentify) {
        this.wxIdentify = wxIdentify;
    }
	
	
    public String getWxImage() {
        return this.wxImage;
    }
    
    public void setWxImage(String wxImage) {
        this.wxImage = wxImage;
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
		 buffer.append("id").append("='").append(getId()).append("' ");			
		 buffer.append("wxIdentify").append("='").append(getWxIdentify()).append("' ");			
		 buffer.append("wxImage").append("='").append(getWxImage()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof WxImageConf) ) return false;
		WxImageConf castOther = ( WxImageConf ) other; 
         
		return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getWxIdentify()==castOther.getWxIdentify()) || ( this.getWxIdentify()!=null && castOther.getWxIdentify()!=null && this.getWxIdentify().equals(castOther.getWxIdentify()) ) )
 && ( (this.getWxImage()==castOther.getWxImage()) || ( this.getWxImage()!=null && castOther.getWxImage()!=null && this.getWxImage().equals(castOther.getWxImage()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
		result = 37 * result + ( getWxIdentify() == null ? 0 : this.getWxIdentify().hashCode() );
		result = 37 * result + ( getWxImage() == null ? 0 : this.getWxImage().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
