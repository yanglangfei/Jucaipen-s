package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   产品
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable{
	/**
	 * 产品信息当前页
	 */
	private int pager;
	/**
	 * 产品信息总页数
	 */
	private int totlePager;
	/**
	 * 产品id
	 */
	private int id;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品价格
	 */
	private String price;
	private String remark;
	private int pxId;
	private String ediByWeb;
	
	public Product(int id, String name, String price, String remark, int pxId,
			String ediByWeb) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.remark = remark;
		this.pxId = pxId;
		this.ediByWeb = ediByWeb;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getEdiByWeb() {
		return ediByWeb;
	}
	public void setEdiByWeb(String ediByWeb) {
		this.ediByWeb = ediByWeb;
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
