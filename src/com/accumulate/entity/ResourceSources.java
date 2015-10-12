package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   信息来源
 *
 */
@SuppressWarnings("serial")
public class ResourceSources implements Serializable {
	/**
	 * 信息来源当前页
	 */
	private int pager;
	/**
	 * 信息来源总页数
	 */
	private int totlePager;
	/**
	 * 来源id
	 */
	private int id;
	/**
	 * 信息来源名称
	 */
	private String fromName;
	/**
	 * 信息来源网页
	 */
	private String fromHtml;
	/**
	 * 排序
	 */
	private int sortId;
	
	public ResourceSources(int id, String fromName, String fromHtml, int sortId) {
		this.id = id;
		this.fromName = fromName;
		this.fromHtml = fromHtml;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getFromHtml() {
		return fromHtml;
	}
	public void setFromHtml(String fromHtml) {
		this.fromHtml = fromHtml;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	
	

}
