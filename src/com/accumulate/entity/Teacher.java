package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   教师
 */
@SuppressWarnings("serial")
public class Teacher implements Serializable {
	/**
	 * 教师信息当前页
	 */
	private int page;
	/**
	 * 教师信息总页数
	 */
	private int totlePage;
	/**
	 * id 
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 图片url
	 */
	private String photoUrl;
	/**
	 * 概要
	 */
	private String summary;
	/**
	 * 主体
	 */
	private String bodys;
	/**
	 * 排序
	 */
	private int px;
	
	
	public Teacher(int id, String name, String photoUrl, String summary,
			String bodys, int px) {
		this.id = id;
		this.name = name;
		this.photoUrl = photoUrl;
		this.summary = summary;
		this.bodys = bodys;
		this.px = px;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
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
	
	
	

}
