package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 *  省份
 */
@SuppressWarnings("serial")
public class Province implements Serializable {
	/**
	 * 省份信息当前页
	 */
	private int pager;
	/**
	 * 省份信息总页数
	 */
	private int totlePager;
	/**
	 * 省份id
	 */
	private int id;
	/**
	 * 省份name
	 */
	private String name;
	/**
	 * 排序
	 */
	private int ProSort;
	/**
	 *  备注
	 */
	private String proRemark;
	
	public Province(int id, String name, int sortId) {
		this.id = id;
		this.name = name;
		this.ProSort = sortId;
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
	public int getProSort() {
		return ProSort;
	}
	public void setProSort(int proSort) {
		ProSort = proSort;
	}
	public String getProRemark() {
		return proRemark;
	}
	public void setProRemark(String proRemark) {
		this.proRemark = proRemark;
	}
	
	
	

}
