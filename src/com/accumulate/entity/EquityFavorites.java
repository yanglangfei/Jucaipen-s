package com.accumulate.entity;

import java.io.Serializable;
/**
 * @author ylf
 * 
 *   收藏股权
 *
 */
@SuppressWarnings("serial")
public class EquityFavorites implements Serializable {
	/**
	 * 收藏股权当前页
	 */
	private int pager;
	/**
	 * 收藏股权总页数
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
	 * 股权id
	 */
	private int eId;
	/**
	 * 收藏时间
	 */
	private String date;
	
	public EquityFavorites() {
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
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
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
