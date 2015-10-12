package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   收藏新闻
 *
 */
@SuppressWarnings("serial")
public class NewsFavorites implements Serializable {
	/**
	 *  新闻收藏当前页
	 */
	private int pager;
	/**
	 *  新闻收藏信息总页数
	 */
	private int totlePager;
	/**
	 * 收藏id
	 */
	private int id;
	/**
	 * 收藏者id
	 */
	private int uId;
	/**
	 * 新闻id
	 */
	private int nId;
	/**
	 * 收藏时间
	 */
	private String date;
	
	public NewsFavorites() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
