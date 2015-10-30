package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class OrderItem implements Serializable{
     private int id;
     private int orderId;
     private int productId;
     private String price;
     private String nowPrice;
     private int buyCount;
     private String allMoney;
     private String productTitle;
     private int contraceYear;
     private int contraceMoth;
     private int contractDay;
     private int isDelete;
	public OrderItem(int id, int orderId, int productId, String price,
			String nowPrice, int buyCount, String allMoney,
			String productTitle, int contraceYear, int contraceMoth,
			int contractDay, int isDelete) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.nowPrice = nowPrice;
		this.buyCount = buyCount;
		this.allMoney = allMoney;
		this.productTitle = productTitle;
		this.contraceYear = contraceYear;
		this.contraceMoth = contraceMoth;
		this.contractDay = contractDay;
		this.isDelete = isDelete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public int getContraceYear() {
		return contraceYear;
	}
	public void setContraceYear(int contraceYear) {
		this.contraceYear = contraceYear;
	}
	public int getContraceMoth() {
		return contraceMoth;
	}
	public void setContraceMoth(int contraceMoth) {
		this.contraceMoth = contraceMoth;
	}
	public int getContractDay() {
		return contractDay;
	}
	public void setContractDay(int contractDay) {
		this.contractDay = contractDay;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
     
     
}
