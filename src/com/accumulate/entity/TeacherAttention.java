package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   关注讲师
 *
 */
@SuppressWarnings("serial")
public class TeacherAttention implements Serializable{
	/**
	 * 总页数
	 */
	private int totlePage;
	/**
	 *  当前页数
	 */
	private int page;
	/**
	 * 关注id
	 */
	private int id;
	/**
	 * 关注用户
	 */
	private int userId;
	/**
	 * 关注的讲师id
	 */
	private int teacherId;
	public TeacherAttention(int id, int userId, int teacherId) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
	}
	
	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	

}
