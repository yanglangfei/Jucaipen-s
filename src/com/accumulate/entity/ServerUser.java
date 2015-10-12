package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 *
 */
@SuppressWarnings("serial")
public class ServerUser implements Serializable{
	private int id;
	private String trueName;
	private String codeNum;
	private int pxId;
	private String remark;
	private String photoUrl;
	public ServerUser(int id, String trueName, String codeNum, int pxId,
			String remark, String photoUrl) {
		this.id = id;
		this.trueName = trueName;
		this.codeNum = codeNum;
		this.pxId = pxId;
		this.remark = remark;
		this.photoUrl = photoUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getCodeNum() {
		return codeNum;
	}
	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
	

}
