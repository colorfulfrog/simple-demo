package com.yxcoach.common.base.entity;

import java.io.Serializable;

/**
 * 
 * @Description  附件 属性
 * Created by yangzhipeng on 2017年7月6日
 */
public class AttachmentInfo implements Serializable {
	
	private static final long serialVersionUID = 2841713888137800731L;
	
	private String name;	        //附件名称
	private String realName;        //真实名称
	private String contentType;     //文件类型
	private String fileUrl;		    //文件路径
	private long   fileSize;		//文件大小
	private int    imageWidth;      //图片宽度  jpg,png,gif等图片类型才保存宽高 
	private int    imageHeight;     //图片高度

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	
}
