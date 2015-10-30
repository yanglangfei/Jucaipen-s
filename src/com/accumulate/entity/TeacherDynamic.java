package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   讲师动态
 *
 */
@SuppressWarnings("serial")
public class TeacherDynamic implements Serializable{
	/**
	 *  讲师动态id
	 */
	private int id;
	/**
	 * 讲师关联id 关联日志ID、回答ID、直播详情ID
	 */
	private int relateId;
	/**
	 * 讲师关联分类  0表示发布直播、1表示发布日志、2表示回答问题
	 */
	private int relateType;
	/**
	 * 发布动态时间
	 */
	private String insertDate;
	
	public TeacherDynamic(int id, int relateId, int relateType,
			String insertDate) {
		this.id = id;
		this.relateId = relateId;
		this.relateType = relateType;
		this.insertDate = insertDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelateId() {
		return relateId;
	}
	public void setRelateId(int relateId) {
		this.relateId = relateId;
	}
	public int getRelateType() {
		return relateType;
	}
	public void setRelateType(int relateType) {
		this.relateType = relateType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
