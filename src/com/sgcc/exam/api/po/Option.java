package com.sgcc.exam.api.po;

public class Option {
	private String option;
	private String text;
	private String img;
	
	public Option(){}

	public void clear(){
		this.option=null;
		this.text=null;
		this.img=null;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Option [option=" + option + ", text=" + text + ", img=" + img + "]";
	}
	 
	
}
