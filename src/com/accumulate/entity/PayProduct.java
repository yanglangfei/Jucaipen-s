package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   商品
 *
 */
@SuppressWarnings("serial")
public class PayProduct implements Serializable{
	/**
	 * id 
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String productTitle;
	/**
	 * 原价
	 */
	private String price;
	/**
	 * 现价
	 */
	private String nowPrice;
	/**
	 * 讲师Id(等于0时，该产品为系统产品，不属于某个讲师的产品)
	 */
	private int teacherId;
	/**
	 * 产品类型（1：一次性销售；2：续约型销售）
	 */
	private int type;
	private int pxId;
	/**
	 * 续约年数
	 */
	private int contractYear;
	/**
	 * 续约月数
	 */
	private int contractMoth;
	/**
	 * 续约天数
	 */
	private int contraceDay;
	/**
	 * 销售状态（1：正常销售；2：暂停销售）
	 */
	private int state;
	/**
	 * 产品状态（1：正常；4：删除）
	 */
	private int isDelete;
	public PayProduct(int id, String productTitle, String price,
			String nowPrice, int teacherId, int type, int pxId,
			int contractYear, int contractMoth, int contraceDay, int state,
			int isDelete) {
		this.id = id;
		this.productTitle = productTitle;
		this.price = price;
		this.nowPrice = nowPrice;
		this.teacherId = teacherId;
		this.type = type;
		this.pxId = pxId;
		this.contractYear = contractYear;
		this.contractMoth = contractMoth;
		this.contraceDay = contraceDay;
		this.state = state;
		this.isDelete = isDelete;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	public int getContractYear() {
		return contractYear;
	}
	public void setContractYear(int contractYear) {
		this.contractYear = contractYear;
	}
	public int getContractMoth() {
		return contractMoth;
	}
	public void setContractMoth(int contractMoth) {
		this.contractMoth = contractMoth;
	}
	public int getContraceDay() {
		return contraceDay;
	}
	public void setContraceDay(int contraceDay) {
		this.contraceDay = contraceDay;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	

}
