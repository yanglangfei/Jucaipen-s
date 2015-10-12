package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 *
 */
@SuppressWarnings("serial")
public class ServerClass implements Serializable{
	private int id;
	private String name;
	private String remark;
	private int pxId;
	
	public ServerClass(int id, String name, String remark, int pxId) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.pxId = pxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	
	

}
