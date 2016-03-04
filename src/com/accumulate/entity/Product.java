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
	private String productTitle;
	/**
	 * 产品原价
	 */
	private String price;
	/**
	 * 现价
	 */
	private String nowPrice;
	
	/**
	 *  讲师ID   讲师Id(等于0时，该产品为系统产品，不属于某个讲师的产品)
	 */
	private int tearchId;
	/**
	 *   产品类型（1：一次性销售；2：续约型销售）
	 */
	private int types;
	/**
	 * 此字段为续约性产品专用字段（值为续约年数）
	 */
	private int xuYueYear;
	/**
	 * 此字段为续约性产品专用字段（值为续约月数）
	 */
	private int xuYueMonth;
	/**
	 *  此字段为续约性产品专用字段（值为续约天数）
	 */
	private int xuYueDay;
	/**
	 * 销售状态（1：正常销售；2：暂停销售）
	 */
	private int saleType;
	/**
	 * 产品状态（1：正常；4：删除）
	 */
	private int isDelete;
	/**
	 *   排序
	 */
	private int pxId;
	public Product(int pager, int totlePager, int id, String productTitle,
			String price, String nowPrice, int tearchId, int types,
			int xuYueYear, int xuYueMonth, int xuYueDay, int saleType,
			int isDelete, int pxId) {
		super();
		this.pager = pager;
		this.totlePager = totlePager;
		this.id = id;
		this.productTitle = productTitle;
		this.price = price;
		this.nowPrice = nowPrice;
		this.tearchId = tearchId;
		this.types = types;
		this.xuYueYear = xuYueYear;
		this.xuYueMonth = xuYueMonth;
		this.xuYueDay = xuYueDay;
		this.saleType = saleType;
		this.isDelete = isDelete;
		this.pxId = pxId;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}
	public int getTearchId() {
		return tearchId;
	}
	public void setTearchId(int tearchId) {
		this.tearchId = tearchId;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public int getXuYueYear() {
		return xuYueYear;
	}
	public void setXuYueYear(int xuYueYear) {
		this.xuYueYear = xuYueYear;
	}
	public int getXuYueMonth() {
		return xuYueMonth;
	}
	public void setXuYueMonth(int xuYueMonth) {
		this.xuYueMonth = xuYueMonth;
	}
	public int getXuYueDay() {
		return xuYueDay;
	}
	public void setXuYueDay(int xuYueDay) {
		this.xuYueDay = xuYueDay;
	}
	public int getSaleType() {
		return saleType;
	}
	public void setSaleType(int saleType) {
		this.saleType = saleType;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

	

}
