package com.sgcc.exam.rguser.po;

import java.util.Date;

/**
 * MUser
 * @author Administrator
 * @date 2019-03-06
 */
public class MUser implements java.io.Serializable {
	
	
    
	/** 用户ID*/
	
	private String mUserId;
	
	/** 微信用户唯一标识*/
	
	private String openId;
	
	/** 归属区域ID*/
	
	private String areaId;
	
	/** 微信昵称*/
	
	private String nickName;
	
	/** 微信头像URL*/
	
	private String photoUrl;
	
	/** 性别*/
	
	private String gender;
	
	/** 最后登陆时间*/
	
	private Date loginDate;
	
	
	/**虚拟主键*/
	private String mxVirtualId;
	

    /** 无参构造方法 */
    public MUser() {
    } 
    
		
	/** 构造方法 */
	public MUser(String mUserId) {
	    this.mUserId = mUserId;
	 }
	 	   
	
	
    public String getmUserId() {
        return this.mUserId;
    }
    
    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }
	
	
    public String getOpenId() {
        return this.openId;
    }
    
    public void setOpenId(String openId) {
        this.openId = openId;
    }
	
	
    public String getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
	
	
    public String getNickName() {
        return this.nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
	
	
    public String getPhotoUrl() {
        return this.photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
	
	
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
	
	
    public Date getLoginDate() {
        return this.loginDate;
    }
    
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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
		 buffer.append("mUserId").append("='").append(getmUserId()).append("' ");			
		 buffer.append("openId").append("='").append(getOpenId()).append("' ");			
		 buffer.append("areaId").append("='").append(getAreaId()).append("' ");			
		 buffer.append("nickName").append("='").append(getNickName()).append("' ");			
		 buffer.append("photoUrl").append("='").append(getPhotoUrl()).append("' ");			
		 buffer.append("gender").append("='").append(getGender()).append("' ");			
		 buffer.append("loginDate").append("='").append(getLoginDate()).append("' ");			
		 buffer.append("mxVirtualId").append("='").append(getMxVirtualId()).append("' ");			
		 buffer.append("]");
      
         return buffer.toString();
     }

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof MUser) ) return false;
		MUser castOther = ( MUser ) other; 
         
		return ( (this.getmUserId()==castOther.getmUserId()) || ( this.getmUserId()!=null && castOther.getmUserId()!=null && this.getmUserId().equals(castOther.getmUserId()) ) )
 && ( (this.getOpenId()==castOther.getOpenId()) || ( this.getOpenId()!=null && castOther.getOpenId()!=null && this.getOpenId().equals(castOther.getOpenId()) ) )
 && ( (this.getAreaId()==castOther.getAreaId()) || ( this.getAreaId()!=null && castOther.getAreaId()!=null && this.getAreaId().equals(castOther.getAreaId()) ) )
 && ( (this.getNickName()==castOther.getNickName()) || ( this.getNickName()!=null && castOther.getNickName()!=null && this.getNickName().equals(castOther.getNickName()) ) )
 && ( (this.getPhotoUrl()==castOther.getPhotoUrl()) || ( this.getPhotoUrl()!=null && castOther.getPhotoUrl()!=null && this.getPhotoUrl().equals(castOther.getPhotoUrl()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getLoginDate()==castOther.getLoginDate()) || ( this.getLoginDate()!=null && castOther.getLoginDate()!=null && this.getLoginDate().equals(castOther.getLoginDate()) ) )
 && ( (this.getMxVirtualId()==castOther.getMxVirtualId()) || ( this.getMxVirtualId()!=null && castOther.getMxVirtualId()!=null && this.getMxVirtualId().equals(castOther.getMxVirtualId()) ) );
   }
   
   public int hashCode() {
       int result = 17;
         
		result = 37 * result + ( getmUserId() == null ? 0 : this.getmUserId().hashCode() );
		result = 37 * result + ( getOpenId() == null ? 0 : this.getOpenId().hashCode() );
		result = 37 * result + ( getAreaId() == null ? 0 : this.getAreaId().hashCode() );
		result = 37 * result + ( getNickName() == null ? 0 : this.getNickName().hashCode() );
		result = 37 * result + ( getPhotoUrl() == null ? 0 : this.getPhotoUrl().hashCode() );
		result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
		result = 37 * result + ( getLoginDate() == null ? 0 : this.getLoginDate().hashCode() );
		result = 37 * result + ( getMxVirtualId() == null ? 0 : this.getMxVirtualId().hashCode() );
		return result;
   }   

}
