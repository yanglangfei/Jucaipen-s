package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  提问
 */
@SuppressWarnings("serial")
public class Ask implements Serializable{
	/**
	 * 提问当前页数
	 */
	private int page;
	/**
	 * 提问总页数
	 */
	private int totlePage;
	/**
	 *  提问id
	 */
	private int id;
	/**
	 * 提问用户id
	 */
	private int userId;
	private int parentId;
	/**
	 * 提问内容
	 */
	private String askBody;
	/**
	 * 分类id
	 */
	private int classId;
	/**
	 * 提问时间
	 */
	private String askDate;
	/**
	 * 点击数
	 */
	private int hits;
	/**
	 * 是否恢复
	 */
	private int isReply;
	/**
	 *  提问者ip
	 */
	private String ip;
	/**
	 * 被提问老师id
	 */
	private int teacherId;
	/**
	 * 提问状态
	 */
	private int askState;
	public Ask() {
	}
	
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getTotlePage() {
		return totlePage;
	}


	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}


	public int getAskState() {
		return askState;
	}

	public void setAskState(int askState) {
		this.askState = askState;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
	

}
