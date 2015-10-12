package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 *
 */
@SuppressWarnings("serial")
public class Friends implements Serializable{
	private int id;
	private String linkName;
	private String linkUrl;
	private int pxId;
	private int isShow;
	
	public Friends(int id, String linkName, String linkUrl, int pxId, int isShow) {
		this.id = id;
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.pxId = pxId;
		this.isShow = isShow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	
	
	

}
